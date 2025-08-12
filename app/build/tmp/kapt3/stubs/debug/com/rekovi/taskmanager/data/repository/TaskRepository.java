package com.rekovi.taskmanager.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J$\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&\u00a8\u0006\u0010"}, d2 = {"Lcom/rekovi/taskmanager/data/repository/TaskRepository;", "", "getTaskById", "Lcom/rekovi/taskmanager/domain/model/Card;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTasks", "", "permissionType", "Lcom/rekovi/taskmanager/domain/model/PermissionType;", "userEmail", "(Lcom/rekovi/taskmanager/domain/model/PermissionType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValidPhases", "observeTasksRealtime", "Lkotlinx/coroutines/flow/Flow;", "app_debug"})
public abstract interface TaskRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTasks(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.PermissionType permissionType, @org.jetbrains.annotations.NotNull()
    java.lang.String userEmail, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.rekovi.taskmanager.domain.model.Card>> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.rekovi.taskmanager.domain.model.Card>> observeTasksRealtime(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.PermissionType permissionType, @org.jetbrains.annotations.NotNull()
    java.lang.String userEmail);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTaskById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.Card> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.String> getValidPhases();
}