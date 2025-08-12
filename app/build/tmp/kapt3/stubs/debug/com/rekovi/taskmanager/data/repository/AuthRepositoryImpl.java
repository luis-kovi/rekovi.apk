package com.rekovi.taskmanager.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/rekovi/taskmanager/data/repository/AuthRepositoryImpl;", "Lcom/rekovi/taskmanager/data/repository/AuthRepository;", "supabaseClient", "Lcom/rekovi/taskmanager/data/source/remote/SupabaseClient;", "preferencesManager", "Lcom/rekovi/taskmanager/data/source/local/PreferencesManager;", "(Lcom/rekovi/taskmanager/data/source/remote/SupabaseClient;Lcom/rekovi/taskmanager/data/source/local/PreferencesManager;)V", "getCurrentUser", "Lcom/rekovi/taskmanager/domain/model/User;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserPermissions", "Lcom/rekovi/taskmanager/domain/model/PreApprovedUser;", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUserLoggedIn", "Lkotlinx/coroutines/flow/Flow;", "", "login", "Lcom/rekovi/taskmanager/domain/model/AuthResult;", "loginRequest", "Lcom/rekovi/taskmanager/domain/model/LoginRequest;", "(Lcom/rekovi/taskmanager/domain/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginWithGoogle", "idToken", "displayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "refreshSession", "app_debug"})
public final class AuthRepositoryImpl implements com.rekovi.taskmanager.data.repository.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.rekovi.taskmanager.data.source.remote.SupabaseClient supabaseClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.rekovi.taskmanager.data.source.local.PreferencesManager preferencesManager = null;
    
    @javax.inject.Inject()
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.data.source.remote.SupabaseClient supabaseClient, @org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.data.source.local.PreferencesManager preferencesManager) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object loginWithGoogle(@org.jetbrains.annotations.NotNull()
    java.lang.String idToken, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.lang.String displayName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.AuthResult> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object login(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.LoginRequest loginRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.AuthResult> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.User> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUserPermissions(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.PreApprovedUser> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> isUserLoggedIn() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object refreshSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}