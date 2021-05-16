-- Exemplo para inserção de dados na tabela de cliente
INSERT INTO CLIENTE(cpf, rg, nome) VALUES ('584.135.050-11', '16.186.629-3', 'Celebli');
INSERT INTO CLIENTE(cpf, rg, nome) VALUES ('877.441.750-93', '26.805.220-7', 'Maxokral');
INSERT INTO CLIENTE(cpf, rg, nome) VALUES ('505.306.920-40', '12.903.362-5', 'Ciorbe');
INSERT INTO CLIENTE(cpf, rg, nome) VALUES ('596.519.770-51', '13.203.583-2', 'Soegi');
INSERT INTO CLIENTE(cpf, rg, nome) VALUES ('639.839.350-36', '10.220.526-7', 'Deoxubir');
INSERT INTO CLIENTE(cpf, rg, nome) VALUES ('611.246.140-44', '35.552.083-7', 'Brompo');
INSERT INTO CLIENTE(cpf, rg, nome) VALUES ('094.954.800-60', '17.904.021-2', 'Porandir');
INSERT INTO CLIENTE(cpf, rg, nome) VALUES ('328.679.340-01', '49.054.293-1', 'Maor');
INSERT INTO CLIENTE(cpf, rg, nome) VALUES ('851.211.850-49', '24.751.006-3', 'Mazwuwa');

-- Exemplo para inserção de dados na tabela de contatos
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('09999-9999', '9999-9999'); -- 1
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('02521-3452', '3451-4523'); -- 2
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('03342-9999', '1245-2312'); -- 3
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('14224-9564', '1241-3467'); -- 4
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('07777-6666', '3456-7890'); -- 5
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('02334-9999', '3453-3421'); -- 6
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('03456-9999', '8567-1234'); -- 7
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('03453-9999', '5634-4234'); -- 8
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('01342-9999', '9077-5345'); -- 9
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('07424-9999', '9088-8901'); -- 10


-- Exemplo para inserção de dados na tabela de endereco
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('Barra do Piraí', '27135-630', 'Caixa DÁgua Velha', 'Rua Francisco Franco', '925'); -- 1
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '5422-630', 'São Miguel Paulista', 'Rua Avelino Costa', '220'); -- 2
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '7544-521', 'Vila Ré', 'Rua Meire Ortolano', '28'); -- 3
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '2342-123', 'Vila Clementino', 'Rua Olavo Bilac', '30'); -- 4
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '3453-234', 'Vila Curuçá', 'Rua Paulo Joens', '30'); -- 5
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '6546-567', 'Vila Clemens', 'Rua Jordânia', '55'); -- 6
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '5342-890', 'Santana', 'Rua Treze', '66'); -- 7
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '2342-000', 'Lapa', 'Rua Dora Martins', '77'); -- 8
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '3131-233', 'Barra Funda', 'Rua Sara Rose', '88'); -- 9
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '1341-333', 'Sé', 'Rua Dário Demens', '99'); -- 10


-- Exemplo para inserção de dados na tabela de fornecedor
--INSERT INTO FORNECEDOR()
--SELECT contato.id, endereco.id
--FROM
-- É necessário criar as referências de FK de CONTATO e ENDERECO para cadastrar FORNECEDOR
-- veja: https://pt.stackoverflow.com/questions/335489/sql-como-faço-um-insert-into-em-uma-tabela-que-tem-fk
INSERT INTO FORNECEDOR(razao_social, nome_fantasia, email, descricao, contato, endereco)
VALUES ('Pedigree Fornecimento','Pedigree','pedigree@pedigree.com','Fornecedor Pedigree',3, 2); -- 1
INSERT INTO FORNECEDOR(razao_social, nome_fantasia, email, descricao, contato, endereco)
VALUES ('DuBom Fornecimento','Rações DuBom','dubom@hotmail.com','Fornecedor Rações DuBom',5, 3); -- 2
INSERT INTO FORNECEDOR(razao_social, nome_fantasia, email, descricao, contato, endereco)
VALUES ('Mil Fornecimento','Rações Mil','racoesmil@outlook.com','Fornecedor Rações Mil',6, 4); -- 3
INSERT INTO FORNECEDOR(razao_social, nome_fantasia, email, descricao, contato, endereco)
VALUES ('Dez Fornecimento','Rações Dez','racoesdez@outlook.com','Fornecedor Rações Dez',7, 5); -- 4
INSERT INTO FORNECEDOR(razao_social, nome_fantasia, email, descricao, contato, endereco)
VALUES ('Royal Canin Fornecimento','Royal Canin','fornecimento@royalcanin.com.br','Fornecedor Royal Canin',8, 6); -- 5

-- Cadastro da Mercadoria 1
INSERT INTO LOCAL(id, cep, setor, capacidade) VALUES (5,'76913-559', '13B', '10 Toneladas');
INSERT INTO LOTE(id,data_fabricacao, data_vencimento)
VALUES(6,parsedatetime('2020-10-17', 'yyyy-MM-dd'),parsedatetime('2022-10-17', 'yyyy-MM-dd') );
INSERT INTO MERCADORIA(nome, marca, descricao, fornecedor)
VALUES ('Magnus Adulto Frango e Vegetais', 'Magnus', 'Ração Seca, com grãos médios, com embalagens de 15kg a 25kg',2);
INSERT INTO ITEM_ESTOCADO(id,preco_compra, preco_venda, quantidade,local, lote, mercadoria)
VALUES (15,10.90, 11.90, 20, 5, 6, 1);
----------------------------------------------------------------------------------------------------------------------
-- Cadastro da Mercadoria 2
INSERT INTO LOCAL(id, cep, setor, capacidade) VALUES (6,'76914-560', '13C', '20 Toneladas');
INSERT INTO LOTE(id,data_fabricacao, data_vencimento)
VALUES(7,parsedatetime('2019-09-17', 'yyyy-MM-dd'),parsedatetime('2023-09-18', 'yyyy-MM-dd') );
INSERT INTO MERCADORIA(nome, marca, descricao, fornecedor)
VALUES ('Royal Canin Medium', 'Royal Canin', 'Ração com embalagens de 15kg',5);
INSERT INTO ITEM_ESTOCADO(id,preco_compra, preco_venda, quantidade,local, lote, mercadoria)
VALUES (16,9.85, 13.56, 30, 6, 7, 2);