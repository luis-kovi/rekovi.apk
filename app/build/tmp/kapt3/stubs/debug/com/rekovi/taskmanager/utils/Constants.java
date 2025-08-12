package com.rekovi.taskmanager.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/rekovi/taskmanager/utils/Constants;", "", "()V", "MAX_CARDS_LIMIT", "", "REALTIME_UPDATE_INTERVAL", "", "SUPABASE_ANON_KEY", "", "SUPABASE_URL", "TABLE_PRE_APPROVED_USERS", "VALID_PHASES", "", "getVALID_PHASES", "()Ljava/util/List;", "VIEW_PIPEFY_CARDS_DETAILED", "PermissionTypes", "UserStatus", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUPABASE_URL = "https://SEU_PROJETO.supabase.co";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUPABASE_ANON_KEY = "SUA_CHAVE_ANONIMA_AQUI";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLE_PRE_APPROVED_USERS = "pre_approved_users";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VIEW_PIPEFY_CARDS_DETAILED = "v_pipefy_cards_detalhada";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> VALID_PHASES = null;
    public static final int MAX_CARDS_LIMIT = 100000;
    public static final long REALTIME_UPDATE_INTERVAL = 10000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.rekovi.taskmanager.utils.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getVALID_PHASES() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/rekovi/taskmanager/utils/Constants$PermissionTypes;", "", "()V", "ADMIN", "", "ATIVA", "CHOFER", "KOVI", "ONSYSTEM", "app_debug"})
    public static final class PermissionTypes {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String ADMIN = "admin";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String KOVI = "kovi";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String ATIVA = "ativa";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String ONSYSTEM = "onsystem";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String CHOFER = "chofer";
        @org.jetbrains.annotations.NotNull()
        public static final com.rekovi.taskmanager.utils.Constants.PermissionTypes INSTANCE = null;
        
        private PermissionTypes() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/rekovi/taskmanager/utils/Constants$UserStatus;", "", "()V", "ACTIVE", "", "INACTIVE", "app_debug"})
    public static final class UserStatus {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String ACTIVE = "active";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String INACTIVE = "inactive";
        @org.jetbrains.annotations.NotNull()
        public static final com.rekovi.taskmanager.utils.Constants.UserStatus INSTANCE = null;
        
        private UserStatus() {
            super();
        }
    }
}