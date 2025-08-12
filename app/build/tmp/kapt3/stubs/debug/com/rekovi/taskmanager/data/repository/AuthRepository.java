package com.rekovi.taskmanager.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a6@\u00a2\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0017H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0019"}, d2 = {"Lcom/rekovi/taskmanager/data/repository/AuthRepository;", "", "getCurrentUser", "Lcom/rekovi/taskmanager/domain/model/User;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserPermissions", "Lcom/rekovi/taskmanager/domain/model/PreApprovedUser;", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUserLoggedIn", "Lkotlinx/coroutines/flow/Flow;", "", "login", "Lcom/rekovi/taskmanager/domain/model/AuthResult;", "loginRequest", "Lcom/rekovi/taskmanager/domain/model/LoginRequest;", "(Lcom/rekovi/taskmanager/domain/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginWithGoogle", "idToken", "displayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "refreshSession", "app_debug"})
public abstract interface AuthRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.LoginRequest loginRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.AuthResult> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object loginWithGoogle(@org.jetbrains.annotations.NotNull()
    java.lang.String idToken, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.lang.String displayName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.AuthResult> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.User> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserPermissions(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.PreApprovedUser> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> isUserLoggedIn();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}