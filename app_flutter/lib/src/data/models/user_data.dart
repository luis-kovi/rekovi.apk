class UserData {
  final String email;
  final String permissionType; // admin | kovi | ativa | onSystem | chofer
  final String? empresa;
  final String status; // active | inactive
  final List<String> areaAtuacao;
  final String? nome;

  const UserData({
    required this.email,
    required this.permissionType,
    required this.status,
    this.empresa,
    this.nome,
    this.areaAtuacao = const [],
  });

  factory UserData.fromMap(Map<String, dynamic> map) {
    final rawArea = map['area_atuacao'];
    final List<String> areas = rawArea is List
        ? rawArea.map((e) => e.toString()).toList()
        : rawArea is String
            ? [rawArea]
            : <String>[];
    return UserData(
      email: (map['email'] ?? '').toString(),
      permissionType: (map['permission_type'] ?? '').toString(),
      empresa: map['empresa']?.toString(),
      status: (map['status'] ?? '').toString(),
      nome: map['nome']?.toString(),
      areaAtuacao: areas,
    );
  }
}


