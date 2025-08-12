package com.rekovi.taskmanager.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0016J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/rekovi/taskmanager/data/repository/TaskRepositoryImpl;", "Lcom/rekovi/taskmanager/data/repository/TaskRepository;", "supabaseClient", "Lcom/rekovi/taskmanager/data/source/remote/SupabaseClient;", "(Lcom/rekovi/taskmanager/data/source/remote/SupabaseClient;)V", "getTaskById", "Lcom/rekovi/taskmanager/domain/model/Card;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTasks", "", "permissionType", "Lcom/rekovi/taskmanager/domain/model/PermissionType;", "userEmail", "(Lcom/rekovi/taskmanager/domain/model/PermissionType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValidPhases", "observeTasksRealtime", "Lkotlinx/coroutines/flow/Flow;", "Companion", "app_debug"})
public final class TaskRepositoryImpl implements com.rekovi.taskmanager.data.repository.TaskRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.rekovi.taskmanager.data.source.remote.SupabaseClient supabaseClient = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> VALID_PHASES = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.rekovi.taskmanager.data.repository.TaskRepositoryImpl.Companion Companion = null;
    
    @javax.inject.Inject()
    public TaskRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.data.source.remote.SupabaseClient supabaseClient) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTasks(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.PermissionType permissionType, @org.jetbrains.annotations.NotNull()
    java.lang.String userEmail, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.rekovi.taskmanager.domain.model.Card>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.rekovi.taskmanager.domain.model.Card>> observeTasksRealtime(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.PermissionType permissionType, @org.jetbrains.annotations.NotNull()
    java.lang.String userEmail) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTaskById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.Card> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.String> getValidPhases() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/rekovi/taskmanager/data/repository/TaskRepositoryImpl$Companion;", "", "()V", "VALID_PHASES", "", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}