package com.rekovi.taskmanager.presentation.tasks.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH\u0003\u001a#\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00032\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\u000fH\u0003\u001a\u001e\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003\u001a.\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0002\u00a8\u0006\u001c"}, d2 = {"DetailRow", "", "label", "", "value", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "isHighlighted", "", "isClickable", "onClick", "Lkotlin/Function0;", "DetailSection", "title", "content", "Landroidx/compose/runtime/Composable;", "TaskDetailContent", "task", "Lcom/rekovi/taskmanager/domain/model/Card;", "onDismiss", "TaskDetailModal", "taskId", "permissionType", "Lcom/rekovi/taskmanager/domain/model/PermissionType;", "tasksViewModel", "Lcom/rekovi/taskmanager/presentation/tasks/TasksViewModel;", "formatDate", "dateString", "app_debug"})
public final class TaskDetailModalKt {
    
    @androidx.compose.runtime.Composable()
    public static final void TaskDetailModal(@org.jetbrains.annotations.NotNull()
    java.lang.String taskId, @org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.PermissionType permissionType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.presentation.tasks.TasksViewModel tasksViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TaskDetailContent(com.rekovi.taskmanager.domain.model.Card task, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DetailSection(java.lang.String title, kotlin.jvm.functions.Function0<kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DetailRow(java.lang.String label, java.lang.String value, androidx.compose.ui.graphics.vector.ImageVector icon, boolean isHighlighted, boolean isClickable, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    private static final java.lang.String formatDate(java.lang.String dateString) {
        return null;
    }
}