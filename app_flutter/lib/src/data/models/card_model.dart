class CardModel {
  final String id;
  final String placa;
  final String nomeDriver;
  final String chofer;
  final String faseAtual;
  final String dataCriacao;
  final String? emailChofer;
  final String? empresaResponsavel;
  final String? modeloVeiculo;
  final String? telefoneContato;
  final String? telefoneOpcional;
  final String? emailCliente;
  final String? enderecoCadastro;
  final String? enderecoRecolha;
  final String? linkMapa;
  final String? origemLocacao;
  final String? valorRecolha;
  final String? custoKmAdicional;
  final String? urlPublica;

  const CardModel({
    required this.id,
    required this.placa,
    required this.nomeDriver,
    required this.chofer,
    required this.faseAtual,
    required this.dataCriacao,
    this.emailChofer,
    this.empresaResponsavel,
    this.modeloVeiculo,
    this.telefoneContato,
    this.telefoneOpcional,
    this.emailCliente,
    this.enderecoCadastro,
    this.enderecoRecolha,
    this.linkMapa,
    this.origemLocacao,
    this.valorRecolha,
    this.custoKmAdicional,
    this.urlPublica,
  });

  factory CardModel.fromMap(Map<String, dynamic> map) {
    return CardModel(
      id: (map['card_id'] ?? '').toString(),
      placa: (map['placa_veiculo'] ?? '').toString(),
      nomeDriver: (map['nome_driver'] ?? '').toString(),
      chofer: (map['nome_chofer_recolha'] ?? '').toString(),
      faseAtual: (map['phase_name'] ?? '').toString(),
      dataCriacao: (map['created_at'] ?? '').toString(),
      emailChofer: map['email_chofer']?.toString(),
      empresaResponsavel: map['empresa_recolha']?.toString(),
      modeloVeiculo: map['modelo_veiculo']?.toString(),
      telefoneContato: map['telefone_contato']?.toString(),
      telefoneOpcional: map['telefone_opcional']?.toString(),
      emailCliente: map['email_cliente']?.toString(),
      enderecoCadastro: map['endereco_cadastro']?.toString(),
      enderecoRecolha: map['endereco_recolha']?.toString(),
      linkMapa: map['link_mapa']?.toString(),
      origemLocacao: map['origem_locacao']?.toString(),
      valorRecolha: map['valor_recolha']?.toString(),
      custoKmAdicional: map['custo_km_adicional']?.toString(),
      urlPublica: map['public_url']?.toString(),
    );
  }
}


