INSERT INTO competencias (id, nome, categoria, descricao) VALUES
 (1, 'Inteligência Artificial', 'Tecnologia', 'Fundamentos de IA e ML'),
 (2, 'Análise de Dados', 'Tecnologia', 'Estatística aplicada e analytics'),
 (3, 'Empatia', 'Comportamental', 'Habilidade socioemocional'),
 (4, 'Colaboração', 'Comportamental', 'Trabalho em equipe');
INSERT INTO trilhas (id, nome, descricao, nivel, carga_horaria, foco_principal) VALUES
 (1, 'Trilha de Dados', 'Fundamentos de dados e estatística', 'INICIANTE', 40, 'Analytics'),
 (2, 'Trilha de Soft Skills', 'Comunicação e trabalho em equipe', 'INICIANTE', 20, 'Habilidades Humanas');
INSERT INTO trilha_competencia (trilha_id, competencia_id) VALUES (1,1), (1,2), (2,3), (2,4);
INSERT INTO usuarios (id, nome, email, area_atuacao, nivel_carreira, data_cadastro) VALUES
 (1, 'Alice Souza', 'alice.souza@example.com', 'Tecnologia', 'Junior', CURRENT_DATE()),
 (2, 'Bruno Silva', 'bruno.silva@example.com', 'Marketing', 'Pleno', CURRENT_DATE());
INSERT INTO matriculas (id, usuario_id, trilha_id, data_inscricao, status) VALUES
 (1, 1, 1, CURRENT_DATE(), 'ATIVA'),
 (2, 2, 2, CURRENT_DATE(), 'ATIVA');