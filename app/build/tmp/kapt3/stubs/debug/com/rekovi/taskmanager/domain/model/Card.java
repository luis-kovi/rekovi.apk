package com.rekovi.taskmanager.domain.model;

@kotlinx.serialization.Serializable()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 d2\u00020\u0001:\u0002cdB\u00d7\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0002\u0010\u001aB\u00d1\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001bJ\t\u0010B\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010M\u001a\u00020\u0005H\u00c6\u0003J\t\u0010N\u001a\u00020\u0005H\u00c6\u0003J\t\u0010O\u001a\u00020\u0005H\u00c6\u0003J\t\u0010P\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00e1\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00d6\u0001J\t\u0010Z\u001a\u00020\u0005H\u00d6\u0001J&\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u00c1\u0001\u00a2\u0006\u0002\bbR\u0011\u0010\u001c\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010 \u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001eR\u0011\u0010(\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010.\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u001eR\u0011\u00100\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b1\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0011\u00103\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b4\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001eR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001eR\u0011\u00107\u001a\u0002088F\u00a2\u0006\u0006\u001a\u0004\b9\u0010:R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001eR\u0011\u0010<\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b=\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\u001eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001e\u00a8\u0006e"}, d2 = {"Lcom/rekovi/taskmanager/domain/model/Card;", "", "seen1", "", "id", "", "placa", "nomeDriver", "chofer", "faseAtual", "dataCriacao", "emailChofer", "empresaResponsavel", "modeloVeiculo", "telefoneContato", "telefoneOpcional", "emailCliente", "enderecoCadastro", "enderecoRecolha", "linkMapa", "origemLocacao", "valorRecolha", "custoKmAdicional", "urlPublica", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "adaptedPhaseName", "getAdaptedPhaseName", "()Ljava/lang/String;", "getChofer", "cidadeOrigem", "getCidadeOrigem", "getCustoKmAdicional", "getDataCriacao", "getEmailChofer", "getEmailCliente", "getEmpresaResponsavel", "getEnderecoCadastro", "enderecoCliente", "getEnderecoCliente", "getEnderecoRecolha", "getFaseAtual", "getId", "getLinkMapa", "localizacao", "getLocalizacao", "modelo", "getModelo", "getModeloVeiculo", "nomeCliente", "getNomeCliente", "getNomeDriver", "getOrigemLocacao", "phaseColor", "Lcom/rekovi/taskmanager/domain/model/PhaseColor;", "getPhaseColor", "()Lcom/rekovi/taskmanager/domain/model/PhaseColor;", "getPlaca", "telefoneCliente", "getTelefoneCliente", "getTelefoneContato", "getTelefoneOpcional", "getUrlPublica", "getValorRecolha", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
public final class Card {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String placa = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nomeDriver = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String chofer = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String faseAtual = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String dataCriacao = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String emailChofer = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String empresaResponsavel = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String modeloVeiculo = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String telefoneContato = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String telefoneOpcional = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String emailCliente = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String enderecoCadastro = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String enderecoRecolha = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String linkMapa = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String origemLocacao = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String valorRecolha = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String custoKmAdicional = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String urlPublica = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.rekovi.taskmanager.domain.model.Card.Companion Companion = null;
    
    public Card(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String placa, @org.jetbrains.annotations.NotNull()
    java.lang.String nomeDriver, @org.jetbrains.annotations.NotNull()
    java.lang.String chofer, @org.jetbrains.annotations.NotNull()
    java.lang.String faseAtual, @org.jetbrains.annotations.NotNull()
    java.lang.String dataCriacao, @org.jetbrains.annotations.Nullable()
    java.lang.String emailChofer, @org.jetbrains.annotations.Nullable()
    java.lang.String empresaResponsavel, @org.jetbrains.annotations.Nullable()
    java.lang.String modeloVeiculo, @org.jetbrains.annotations.Nullable()
    java.lang.String telefoneContato, @org.jetbrains.annotations.Nullable()
    java.lang.String telefoneOpcional, @org.jetbrains.annotations.Nullable()
    java.lang.String emailCliente, @org.jetbrains.annotations.Nullable()
    java.lang.String enderecoCadastro, @org.jetbrains.annotations.Nullable()
    java.lang.String enderecoRecolha, @org.jetbrains.annotations.Nullable()
    java.lang.String linkMapa, @org.jetbrains.annotations.Nullable()
    java.lang.String origemLocacao, @org.jetbrains.annotations.Nullable()
    java.lang.String valorRecolha, @org.jetbrains.annotations.Nullable()
    java.lang.String custoKmAdicional, @org.jetbrains.annotations.Nullable()
    java.lang.String urlPublica) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlaca() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNomeDriver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChofer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFaseAtual() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDataCriacao() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmailChofer() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmpresaResponsavel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getModeloVeiculo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTelefoneContato() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTelefoneOpcional() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmailCliente() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEnderecoCadastro() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEnderecoRecolha() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLinkMapa() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOrigemLocacao() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getValorRecolha() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustoKmAdicional() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUrlPublica() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModelo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocalizacao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCidadeOrigem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNomeCliente() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTelefoneCliente() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEnderecoCliente() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rekovi.taskmanager.domain.model.PhaseColor getPhaseColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAdaptedPhaseName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rekovi.taskmanager.domain.model.Card copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String placa, @org.jetbrains.annotations.NotNull()
    java.lang.String nomeDriver, @org.jetbrains.annotations.NotNull()
    java.lang.String chofer, @org.jetbrains.annotations.NotNull()
    java.lang.String faseAtual, @org.jetbrains.annotations.NotNull()
    java.lang.String dataCriacao, @org.jetbrains.annotations.Nullable()
    java.lang.String emailChofer, @org.jetbrains.annotations.Nullable()
    java.lang.String empresaResponsavel, @org.jetbrains.annotations.Nullable()
    java.lang.String modeloVeiculo, @org.jetbrains.annotations.Nullable()
    java.lang.String telefoneContato, @org.jetbrains.annotations.Nullable()
    java.lang.String telefoneOpcional, @org.jetbrains.annotations.Nullable()
    java.lang.String emailCliente, @org.jetbrains.annotations.Nullable()
    java.lang.String enderecoCadastro, @org.jetbrains.annotations.Nullable()
    java.lang.String enderecoRecolha, @org.jetbrains.annotations.Nullable()
    java.lang.String linkMapa, @org.jetbrains.annotations.Nullable()
    java.lang.String origemLocacao, @org.jetbrains.annotations.Nullable()
    java.lang.String valorRecolha, @org.jetbrains.annotations.Nullable()
    java.lang.String custoKmAdicional, @org.jetbrains.annotations.Nullable()
    java.lang.String urlPublica) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void write$Self$app_debug(@org.jetbrains.annotations.NotNull()
    com.rekovi.taskmanager.domain.model.Card self, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/rekovi/taskmanager/domain/model/Card.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/rekovi/taskmanager/domain/model/Card;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated()
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.rekovi.taskmanager.domain.model.Card> {
        @org.jetbrains.annotations.NotNull()
        public static final com.rekovi.taskmanager.domain.model.Card.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.rekovi.taskmanager.domain.model.Card deserialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override()
        public void serialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull()
        com.rekovi.taskmanager.domain.model.Card value) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/rekovi/taskmanager/domain/model/Card$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/rekovi/taskmanager/domain/model/Card;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.serialization.KSerializer<com.rekovi.taskmanager.domain.model.Card> serializer() {
            return null;
        }
    }
}