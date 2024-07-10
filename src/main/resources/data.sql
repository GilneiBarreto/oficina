-- Inserir clientes com endereço
INSERT INTO tb_cliente (nome, telefone, email, endereco)
VALUES ('João da Silva', '(11) 98765-4321', 'joao.silva@email.com', 'Rua A, 123, São Paulo');

INSERT INTO tb_cliente (nome, telefone, email, endereco)
VALUES ('Maria Oliveira', '(11) 91234-5678', 'maria.oliveira@email.com', 'Av. B, 456, Rio de Janeiro');

INSERT INTO tb_cliente (nome, telefone, email, endereco)
VALUES ('Pedro Santos', '(11) 99876-5432', 'pedro.santos@email.com', 'Rua C, 789, Belo Horizonte');

-- Inserir veículos associados aos clientes com ano
INSERT INTO tb_veiculo (marca, modelo, placa, cliente_id, ano)
VALUES ('Volkswagen', 'Gol', 'ABC-1234', 1, 2020); -- cliente_id = 1 (João da Silva)

INSERT INTO tb_veiculo (marca, modelo, placa, cliente_id, ano)
VALUES ('Fiat', 'Palio', 'DEF-5678', 2, 2018); -- cliente_id = 2 (Maria Oliveira)

INSERT INTO tb_veiculo (marca, modelo, placa, cliente_id, ano)
VALUES ('Ford', 'Fiesta', 'GHI-9012', 3, 2019); -- cliente_id = 3 (Pedro Santos)

-- Inserir mecânicos
INSERT INTO tb_mecanico (nome, especialidade)
VALUES ('Carlos Pereira', 'Motor');

INSERT INTO tb_mecanico (nome, especialidade)
VALUES ('Ana Souza', 'Suspensão');

INSERT INTO tb_mecanico (nome, especialidade)
VALUES ('José Silva', 'Elétrica');

-- Inserir serviços
INSERT INTO tb_servico (descricao, preco)
VALUES ('Troca de óleo', 100.00);

INSERT INTO tb_servico (descricao, preco)
VALUES ('Troca de pneus', 300.00);

INSERT INTO tb_servico (descricao, preco)
VALUES ('Manutenção do sistema de freios', 250.00);

-- Inserir ordens de serviço
INSERT INTO tb_ordem_servico (cliente_id, veiculo_id, mecanico_id, descricao, data_abertura, preco, status)
VALUES (1, 1, 1, 'Troca de óleo e filtros', '2024-07-01 10:00:00', 150.00, 1);

INSERT INTO tb_ordem_servico (cliente_id, veiculo_id, mecanico_id, descricao, data_abertura, preco, status)
VALUES (2, 2, 2, 'Manutenção de suspensão', '2024-07-02 11:00:00', 400.00, 1);

INSERT INTO tb_ordem_servico (cliente_id, veiculo_id, mecanico_id, descricao, data_abertura, preco, status)
VALUES (3, 3, 3, 'Revisão geral', '2024-07-03 12:00:00', 600.00, 1);
