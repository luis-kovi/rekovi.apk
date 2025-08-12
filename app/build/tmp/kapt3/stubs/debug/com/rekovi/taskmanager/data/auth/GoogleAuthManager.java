package com.rekovi.taskmanager.data.auth;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0015\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0016\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/rekovi/taskmanager/data/auth/GoogleAuthManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "androidClientId", "", "credentialManager", "Landroidx/credentials/CredentialManager;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignInClient$delegate", "Lkotlin/Lazy;", "webClientId", "clearPreviousSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithGoogle", "Lcom/rekovi/taskmanager/data/auth/GoogleSignInResult;", "tryCredentialManagerAuth", "tryTraditionalGoogleSignIn", "app_debug"})
public final class GoogleAuthManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.credentials.CredentialManager credentialManager = null;
    
    /**
     * Web Client ID do Google Console
     * IMPORTANTE: Usado para Supabase Auth (COMPARTILHADO com versão web)
     * NÃO ALTERAR - mantém compatibilidade com versão web
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String webClientId = "328238966483-cr3gvj8laa7129onpp4i3lqbgf13s7fn.apps.googleusercontent.com";
    
    /**
     * Android Client ID - para usar com SDK tradicional
     * NOVO: Client ID específico para Android (não afeta versão web)
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String androidClientId = "328238966483-f8v6as8g5v2ms4undp16ck9e1l9b4v9h.apps.googleusercontent.com";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy googleSignInClient$delegate = null;
    
    @javax.inject.Inject()
    public GoogleAuthManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final com.google.android.gms.auth.api.signin.GoogleSignInClient getGoogleSignInClient() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object signInWithGoogle(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.data.auth.GoogleSignInResult> $completion) {
        return null;
    }
    
    private final java.lang.Object clearPreviousSession(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object tryCredentialManagerAuth(kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.data.auth.GoogleSignInResult> $completion) {
        return null;
    }
    
    private final java.lang.Object tryTraditionalGoogleSignIn(kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.data.auth.GoogleSignInResult> $completion) {
        return null;
    }
}