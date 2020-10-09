package com.cosmetic.backend.util.constant;

public class MessageConstants {
    public static final String EMAIL_ALREADY_EXISTS = "Email address already exists !";
    public static final String ADMIN_INITIALIZATION = "Admin initialization !";
    public static final String ROLE_ALREADY_EXISTS = "Use role already exists !";
    public static final String USER_REGISTER_SUCCESS = "User registered successfully !";
    public static final String USER_REGISTER_FAIL = "User registered failure !";
    public static final String EMAIL_NOT_FOUND = "User not found with email ";
    public static final String NOT_SET_USER = "Could not set user authentication in security context !";
    public static final String INVALID_EMAIL_PASSW = "Invalid email address or password !";
    public static final String INVALID_EMAIL = "Invalid email address !";
    public static final String INVALID_PASSWORD = "Invalid password !";
    public static final String LOCKED = "User locked !";
    public static final String DISABLE = "User disable !";
    public static final String UNKNOWN = "User unknown !";
    public static final String ROLE_NOT_FOUND = "User not found with role !";
    public static final String CHANGE_PASSWORD_SUCCESS = "Change user password successfully !";
    public static final String INCORRECT_FILE = "Incorrect file format !";
    public static final String EMAIL_INVALIDATE = "Email invalidate !";
    public static final String EMAIL_NULL = "Email cannot be null !";
    public static final String PASSW_LENGTH = "Password length must be greater than 6 characters !";
    public static final String PASSW_NULL = "Password cannot be null !";
    public static final String DOB_NOT_CORRECT = "Birth date is not in the correct format dd/MM/yyyy !";
    public static final String PHONENUMBER_LENGTH = "Phone number cannot be less than 10 characters !";
    public static final String PHONE_NULL = "Phone number ccannot be null !";
    public static final String SEND_MAIL_SUCCESS = "Send mail Success !";
    public static final String RESET_PASSWORD_FAIL = "Reset password fail !";
    public static final String INVALID_FULLNAME= "Full name invalidate !";
    public static final String FULLNAME_NULL= "Full name cannot be null !";
    public static final String INVALID_PHONENUMBER= "Phone number invalidate!";
    public static final String UPDATE_EMPLOYEE_SUCCES = "Update employee succes";
    public static final String NOT_GET_EMPLOYEES_BY_ROLE_NAME = "Not get employee by RoleName !";

    /* JWT */
    public static final String INVALID_JWT_SIGNATURE = "Invalid JWT signature";
    public static final String INVALID_JWT_TOKEN = "Invalid JWT token";
    public static final String EXPIRED_JWT_TOKEN = "Expired JWT token";
    public static final String UNSUPORT_JWT_TOKEN = "Unsupported JWT token";
    public static final String JWT_CLAIMS_EMPTY = "JWT claims string is empty.";

    public static final String SUCCESS = "Success";
    public static final String NOT_AUTHENTICATED = "User Not Authenticated";
    public static final String ACCESS_DENIED = "Access Is Denied";
    public static final String NOT_FOUND = "Not Found";
    public static final String BAD_REQUEST = "Bad Request";
    public static final String SERVER_ERROR = "Internal server error";

    public static final String LOG_LEVEL_WARN = "Log level warn !";

    public static final String FROZE_ROLE_ADMIN = "Can not set Permission for ROLE_ADMIN";
    public static final String INVALID_CONDITION = "Invalid orderBy condition";
    public static final String ROLE_PM_NOT_SET_ROLE_QCQA = "ROLE_PM can't set role for user is ROLE_QCQA";

    /*API Project*/
    public static final String PROJECT_NAME_EXIST = "This Project name was exist";
    public static final String PROJECT_NAME_IS_INVALID = "This Project name is invalid";
    public static final String BRAND_CANNOT_DELETE = "This brand can not delete";
    public static final String PROJECTS_DELETE_SUCCESSFULLY = "Projects delete successfully";
    public static final String PROJECT_START_DATE_IS_INVALID = "This Project startDate is invalid";
    public static final String PROJECT_END_DATE_IS_INVALID = "This Project endDate is invalid";
    public static final String PM_NOT_FOUND = "Not found Project Manager";
    public static final String LEADER_NOT_FOUND = "Not found Leader with this id";
    public static final String SIZE_OF_LIST_MEMBER_IS_INVALID = "Size of list member is invalid";
    public static final String MEMBER_LEFT_THE_PROJECT_SUCCESSFULLY = "Member left the project successfully";
    public static final String MEMBER_NOT_FOUND_IN_THIS_PROJECT = "Member not found in this project";
    public static final String MEMBER_HAS_BEEN_ADDED_TO_PROJECT = "This Member has been add to project";
    public static final String CANNOT_ADD_MEMBER_TO_PROJECT_FULL = "Can not add member into project, number of member is full";
    public static final String CANNOT_ADD_MEMBER_TO_PROJECT = "Can not add member into project";
    public static final String ADMIN_OR_PM_CANNOT_BE_A_MEMBER_PROJECT = "Admin or PM can not be a member of project";
    public static final String MEMBER_PROJECT_IS_INVALID = "members of project is invalid < total size of list current members";
    /*API Product*/
    public static final String PRODUCT_CANNOT_DELETE = "This product can not delete";
    /*API Category*/
    public static final String CATEGORY_CANNOT_DELETE = "This category can not delete";
        /*API Report*/
    public static final String PRODUCTSALE_CANNOT_DELETE = "This product sale can not delete";
    public static final String MEMBER_NOT_EVALUATION_MEMBER = "Member can not evaluation other member";
    public static final String PM_NOT_EVALUATION_LEADER = "PM can not evaluation Leader";
    public static final String SUCCESS_EVALUATION = "Evaluation success !";
    public static final String FAIL_EVALUATION = "Evaluation fail !";
    public static final String VALIDATION_SCORES_EVALUATION = "score cannot be greater than 10 and be less than 0  !";
    public static final String REPORTS_INIT_SUCCESS = "Reports init success";
    public static final String REPORTS_CAN_NOT_INIT = "Reports can not init";

}
