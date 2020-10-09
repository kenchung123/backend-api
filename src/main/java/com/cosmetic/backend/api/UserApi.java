package com.cosmetic.backend.api;

import com.cosmetic.backend.dto.ChangePasswordParam;
import com.cosmetic.backend.dto.JwtAuthenticationStatusDto;
import com.cosmetic.backend.dto.LoginDTO;
import com.cosmetic.backend.dto.UserDTO;
import com.cosmetic.backend.response.APIResponse;
import com.cosmetic.backend.response.APIResponseError;
import com.cosmetic.backend.security.JwtTokenProvider;
import com.cosmetic.backend.service.UserService;
import com.cosmetic.backend.util.SecurityUtil;
import com.cosmetic.backend.util.constant.APIConstants;
import com.cosmetic.backend.util.constant.MessageConstants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserApi {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    JwtTokenProvider tokenProvider;

    @ApiOperation(value = "Login", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = APIConstants.SUCCESS_CODE, message = MessageConstants.SUCCESS),
            @ApiResponse(code = APIConstants.UNAUTHORIZED_CODE, message = MessageConstants.NOT_AUTHENTICATED),
            @ApiResponse(code = APIConstants.FORBIDDEN_CODE, message = MessageConstants.ACCESS_DENIED),
            @ApiResponse(code = APIConstants.NOT_FOUND_CODE, message = MessageConstants.NOT_FOUND),
            @ApiResponse(code = APIConstants.BAD_REQUEST_CODE, message = MessageConstants.BAD_REQUEST),
            @ApiResponse(code = APIConstants.INTERNAL_SERVER_ERROR_CODE, message = MessageConstants.SERVER_ERROR)
    })
    @PostMapping("/signin")
    public APIResponse<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
            System.out.println(loginRequest.getEmail());
            System.out.println(loginRequest.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (DisabledException | LockedException | BadCredentialsException e) {
            if (e.getClass().equals(BadCredentialsException.class)) {
                APIResponseError apiResponseError = APIResponseError.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message(MessageConstants.INVALID_EMAIL_PASSW)
                        .build();
                return APIResponse.errorStatus(apiResponseError, HttpStatus.BAD_REQUEST);

            } else if (e.getClass().equals(DisabledException.class)) {
                return APIResponse.errorStatus(
                        APIConstants.BAD_REQUEST_CODE,
                        MessageConstants.DISABLE,
                        HttpStatus.BAD_REQUEST
                );
            } else if (e.getClass().equals(LockedException.class)) {
                APIResponseError apiResponseError = APIResponseError.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message(MessageConstants.LOCKED)
                        .build();
                return APIResponse.errorStatus(apiResponseError, HttpStatus.BAD_REQUEST);
            } else {
                return APIResponse.errorStatus(
                        APIConstants.BAD_REQUEST_CODE,
                        MessageConstants.UNKNOWN,
                        HttpStatus.BAD_REQUEST
                );
            }
        }
        String jwt = tokenProvider.generateToken(authentication);
        return APIResponse.okStatus(new JwtAuthenticationStatusDto(jwt, SecurityUtil.getRoleName()));
    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userDTO));
    }
    @PostMapping
    public ResponseEntity<?> signup(@RequestBody UserDTO userDTO){
        UserDTO userDTO1 = userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO1);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
@PutMapping("/password-reset")
@ApiOperation(value = "Change Password ", response = List.class)
@ApiResponses(value = {
        @ApiResponse(code = APIConstants.SUCCESS_CODE, message = MessageConstants.SUCCESS),
        @ApiResponse(code = APIConstants.UNAUTHORIZED_CODE, message = MessageConstants.NOT_AUTHENTICATED),
        @ApiResponse(code = APIConstants.FORBIDDEN_CODE, message = MessageConstants.ACCESS_DENIED),
        @ApiResponse(code = APIConstants.NOT_FOUND_CODE, message = MessageConstants.NOT_FOUND),
        @ApiResponse(code = APIConstants.BAD_REQUEST_CODE, message = MessageConstants.BAD_REQUEST),
        @ApiResponse(code = APIConstants.INTERNAL_SERVER_ERROR_CODE, message = MessageConstants.SERVER_ERROR)
})
public APIResponse<?> changePassword(@RequestBody ChangePasswordParam param) {
//    System.out.println(SecurityUtil.getUser());
    if (SecurityUtil.getUser() != null) {
        return APIResponse.okStatus(userService.changePasswordUser(param, SecurityUtil.getUser()));
    }
   return APIResponse.errorStatus(APIConstants.UNAUTHORIZED_CODE, MessageConstants.NOT_AUTHENTICATED, HttpStatus.UNAUTHORIZED);

}
}
