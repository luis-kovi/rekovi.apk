package com.rekovi.taskmanager.presentation.tasks.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a6\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n\u00a2\u0006\u0002\b\f\u00a2\u0006\u0002\b\rH\u0003\u001a<\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014H\u0003\u001a\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u001a\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0003\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u001e\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003\u001a\u001e\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007\u001a\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u00a8\u0006 "}, d2 = {"ClientInfoContent", "", "card", "Lcom/rekovi/taskmanager/domain/model/Card;", "InfoCard", "title", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "InfoRow", "label", "value", "isClickable", "", "onClick", "Lkotlin/Function0;", "ServiceProviderContent", "StatusBadge", "status", "modifier", "Landroidx/compose/ui/Modifier;", "TaskActionsTab", "TaskDetailHeader", "onBack", "TaskDetailScreen", "TaskDetailsTab", "VehicleInfoContent", "app_debug"})
public final class TaskDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void TaskDetailScreen(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.Card card, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TaskDetailHeader(java.lang.String title, kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TaskDetailsTab(com.rekovi.taskmanager.domain.model.Card card) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TaskActionsTab(com.rekovi.taskmanager.domain.model.Card card) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void InfoCard(java.lang.String title, androidx.compose.ui.graphics.vector.ImageVector icon, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.ColumnScope, kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StatusBadge(java.lang.String status, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void VehicleInfoContent(com.rekovi.taskmanager.domain.model.Card card) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ClientInfoContent(com.rekovi.taskmanager.domain.model.Card card) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ServiceProviderContent(com.rekovi.taskmanager.domain.model.Card card) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void InfoRow(java.lang.String label, java.lang.String value, androidx.compose.ui.graphics.vector.ImageVector icon, boolean isClickable, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}