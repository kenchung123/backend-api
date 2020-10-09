package com.cosmetic.backend.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class EMEnum {

    public interface CodeEnum {

        String getCode();

        String getDisplay();
    }

    public interface CodeIntEnum {

        Integer getCode();

        String getDisplay();
    }

    @Getter
    @AllArgsConstructor
    public enum UserStatus implements CodeIntEnum {

        ENABLE(1, "ENABLE"),
        NOTENABLE(0, "NOTENABLE");

        private final Integer code;
        private final String display;
    }

    @Getter
    @AllArgsConstructor
    public enum RoleName implements CodeEnum {

        ROLE_ADMIN("ROLE_ADMIN", "ROLE_ADMIN"),
        ROLE_USER("ROLE_USER","ROLE_USER"),
        ROLE_PM("ROLE_PM", "ROLE_PM"),
        ROLE_LEADER("ROLE_LEADER", "ROLE_LEADER"),
        ROLE_QCQA("ROLE_QCQA", "ROLE_QCQA"),
        ROLE_MEMBER("ROLE_MEMBER", "ROLE_MEMBER");

        private final String code;
        private final String display;
    }
    @Getter
    @AllArgsConstructor
    public enum ResourceName implements CodeEnum {

        USER("USER", "USER"),
        EMPLOYEE("EMPLOYEE", "EMPLOYEE"),
        PROJECT("PROJECT", "PROJECT"),
        REPORT("REPORT", "REPORT");
        private final String code;
        private final String display;
    }

    @Getter
    @AllArgsConstructor
    public enum ReportStatus implements CodeEnum {

        COMPLETE("COMPLETE", "COMPLETE"),
        ONGOING("ONGOING", "ONGOING"),
        OVERDUE("OVERDUE", "OVERDUE");

        private final String code;
        private final String display;

        public String getCode() {
            return code;
        }

        public static boolean contains(String s) {
            for (ReportStatus reportStatus : values())
                if (reportStatus.getCode().equals(s))
                    return true;
            return false;
        }
    }
    @Getter
    @AllArgsConstructor
    public enum ExcelSection implements CodeEnum{
        SUCCESS("SUCCESS","Thêm thành công"),
        FAIL("SUCCESS","Thêm thất bại");
        private final String code;
        private final String display;

    }

    public enum ResourceStatus {
        NON,
        CAN_VIEW,
        CAN_EDIT;

        public static boolean contains(String code) {
            for (ResourceStatus resourceStatus : values())
                if (resourceStatus.equals(code))
                    return true;
            return false;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum ProjectStatus implements CodeEnum {


        ENABLE("ENABLE", "ENABLE"),
        DISABLE("DISABLE", "DISABLE");

        private final String code;
        private final String display;
    }

    public enum ProjectOrderBy {

        ID("id"), NAME("name");

        private String projectOrderByCode;

        ProjectOrderBy(String projectOrderByCode) {
            this.projectOrderByCode = projectOrderByCode;
        }

        public String getProjectOrderByCode() {
            return projectOrderByCode;
        }
        public static boolean contains(String s) {
            for (ProjectOrderBy projectOrderBy : values())
                if (projectOrderBy.getProjectOrderByCode().equals(s))
                    return true;
            return false;
        }
    }

    public enum MemberType {
        MEMBER("MEMBER") , LEADER("LEADER");

        private final String code;

        MemberType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static boolean contains(String s) {
            for (MemberType memberType : values())
                if (memberType.getCode().equals(s))
                    return true;
            return false;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum ReportType implements CodeEnum {

        LEADER("LEADER", "LEADER"),
        MEMBER("MEMBER", "MEMBER"),
        PROJECT("PROJECT", "PROJECT");

        private final String code;
        private final String display;

        public static boolean contains(String code) {
            for (ReportType reportType : values())
                if (reportType.getCode().equals(code))
                    return true;
            return false;
        }
    }

    public enum ReportOrderBy {

        ID("id"), NAME("name");

        private String reportOrderByCode;

        ReportOrderBy(String reportOrderByCode) {
            this.reportOrderByCode = reportOrderByCode;
        }

        public String getReportOrderByCode() {
            return reportOrderByCode;
        }
        public static boolean contains(String s) {
            for (ReportOrderBy reportOrderBy : values())
                if (reportOrderBy.getReportOrderByCode().equals(s))
                    return true;
            return false;
        }
    }
}

