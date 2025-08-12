package com.rekovi.taskmanager.presentation.tasks;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u000fJ\u0010\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010#\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/rekovi/taskmanager/presentation/tasks/TasksViewModel;", "Landroidx/lifecycle/ViewModel;", "taskRepository", "Lcom/rekovi/taskmanager/data/repository/TaskRepository;", "(Lcom/rekovi/taskmanager/data/repository/TaskRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/rekovi/taskmanager/presentation/tasks/TasksUiState;", "permissionType", "Lcom/rekovi/taskmanager/domain/model/PermissionType;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "userEmail", "", "clearError", "", "filterTasks", "", "Lcom/rekovi/taskmanager/domain/model/Card;", "tasks", "searchQuery", "selectedPhase", "getTaskById", "taskId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialize", "loadTasks", "observeRealTimeUpdates", "refreshTasks", "updateSearchQuery", "query", "updateSelectedPhase", "phase", "updateTasksAndFilter", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TasksViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.rekovi.taskmanager.data.repository.TaskRepository taskRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.rekovi.taskmanager.presentation.tasks.TasksUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.rekovi.taskmanager.presentation.tasks.TasksUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private com.rekovi.taskmanager.domain.model.PermissionType permissionType = com.rekovi.taskmanager.domain.model.PermissionType.CHOFER;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String userEmail = "";
    
    @javax.inject.Inject()
    public TasksViewModel(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.data.repository.TaskRepository taskRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.rekovi.taskmanager.presentation.tasks.TasksUiState> getUiState() {
        return null;
    }
    
    public final void initialize(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.PermissionType permissionType, @org.jetbrains.annotations.NotNull()
    java.lang.String userEmail) {
    }
    
    private final void loadTasks() {
    }
    
    private final void observeRealTimeUpdates() {
    }
    
    private final void updateTasksAndFilter(java.util.List<com.rekovi.taskmanager.domain.model.Card> tasks) {
    }
    
    public final void refreshTasks() {
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void updateSelectedPhase(@org.jetbrains.annotations.Nullable()
    java.lang.String phase) {
    }
    
    private final java.util.List<com.rekovi.taskmanager.domain.model.Card> filterTasks(java.util.List<com.rekovi.taskmanager.domain.model.Card> tasks, java.lang.String searchQuery, java.lang.String selectedPhase) {
        return null;
    }
    
    public final void clearError() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTaskById(@org.jetbrains.annotations.NotNull()
    java.lang.String taskId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rekovi.taskmanager.domain.model.Card> $completion) {
        return null;
    }
}