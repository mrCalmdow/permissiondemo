package com.flchen.permissiondemo.permission.constants;

/**
 * @author Beldon
 * @create 2018-04-16 下午3:42
 */
public interface PermissionConstants {
    String SYSTEM_NAME = "shop";

    /**
     * permission
     */
    interface Permission {
        String ACTION = "permission";
        String ADD = SYSTEM_NAME + "_" + ACTION + "_add";
        String UPDATE = SYSTEM_NAME + "_" + ACTION + "_update";
        String DELETE = SYSTEM_NAME + "_" + ACTION + "_delete";
        String GET = SYSTEM_NAME + "_" + ACTION + "_get";
    }

    interface PermissionGroup {
        String ACTION = "permissionGroup";
        String ADD = SYSTEM_NAME + "_" + ACTION + "_add";
        String UPDATE = SYSTEM_NAME + "_" + ACTION + "_update";
        String DELETE = SYSTEM_NAME + "_" + ACTION + "_delete";
        String GET = SYSTEM_NAME + "_" + ACTION + "_get";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
    }

    interface Role {
        String ACTION = "role";
        String ADD = SYSTEM_NAME + "_" + ACTION + "_add";
        String UPDATE = SYSTEM_NAME + "_" + ACTION + "_update";
        String DELETE = SYSTEM_NAME + "_" + ACTION + "_delete";
        String GET = SYSTEM_NAME + "_" + ACTION + "_get";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
        String ENABLE = SYSTEM_NAME + "_" + ACTION + "_enable";
        String DISABLE = SYSTEM_NAME + "_" + ACTION + "_disable";
    }

    interface UserRole {
        String ACTION = "userRole";
        String UPDATE = SYSTEM_NAME + "_" + ACTION + "_update";
        String ADD = SYSTEM_NAME + "_" + ACTION + "_add";
        String DELETE = SYSTEM_NAME + "_" + ACTION + "_delete";
        String LIST_USER = SYSTEM_NAME + "_" + ACTION + "_liseUser";
    }


    interface UserInhouse {
        String ACTION = "userInhouse";
        String SEARCH = SYSTEM_NAME + "_" + ACTION + "_search";
        String ADD = SYSTEM_NAME + "_" + ACTION + "_add";
        String REMOVE = SYSTEM_NAME + "_" + ACTION + "_remove";
        String ENABLE = SYSTEM_NAME + "_" + ACTION + "_enable";
        String DISABLE = SYSTEM_NAME + "_" + ACTION + "_disable";
    }

    interface UserExternal {
        String ACTION = "userExternal";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
        String ADD = SYSTEM_NAME + "_" + ACTION + "_add";
        String UPDATE = SYSTEM_NAME + "_" + ACTION + "_update";
        String DELETE = SYSTEM_NAME + "_" + ACTION + "_delete";
        String GET = SYSTEM_NAME + "_" + ACTION + "_get";
        String ENABLE = SYSTEM_NAME + "_" + ACTION + "_enable";
        String RESET_PASS = SYSTEM_NAME + "_" + ACTION + "_resetPass";
        String DISABLE = SYSTEM_NAME + "_" + ACTION + "_disable";
    }


    interface RetailManager{
        String ACTION = "retailManager";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
        String GET = SYSTEM_NAME + "_" + ACTION + "_get";
        String UPDATE = SYSTEM_NAME + "_" + ACTION + "_update";
        String USER_LIST = SYSTEM_NAME + "_" + ACTION + "_userList";
        String GET_USER = SYSTEM_NAME + "_" + ACTION + "_getUser";
    }


    interface StoreManager{
        String ACTION = "storeManager";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
        String GET = SYSTEM_NAME + "_" + ACTION + "_get";
        String UPDATE = SYSTEM_NAME + "_" + ACTION + "_update";
        String GET_USER = SYSTEM_NAME + "_" + ACTION + "_getUser";

    }


    interface RetailConfirmReconciliation {
        String ACTION = "retailConfirmReconciliation";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
        String OPER = SYSTEM_NAME + "_" + ACTION + "_oper";
        String EXCEL = SYSTEM_NAME + "_" + ACTION + "_excel";
    }

    interface ProcessedReconciliation {
        String ACTION = "processedReconciliation";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
        String EXCEL = SYSTEM_NAME + "_" + ACTION + "_excel";

    }

    interface ExceptionReconciliation{
        String ACTION = "exceptionReconciliation";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
        String EXCEL = SYSTEM_NAME + "_" + ACTION + "_excel";
    }

    interface PutoutReconciliation{
        String ACTION = "putoutReconciliation";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
        String EXCEL = SYSTEM_NAME + "_" + ACTION + "_excel";
    }

    interface AllReconciliationDataList{
        String ACTION = "allReconciliationDataList";
        String LIST = SYSTEM_NAME + "_" + ACTION + "_list";
        String EXCEL = SYSTEM_NAME + "_" + ACTION + "_excel";
    }

}
