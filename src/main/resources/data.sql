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
INSERT INTO CONTATO(telefone_celular, telefone_fixo) VALUES ('08888-9999', '4567-8901'); -- 6


-- Exemplo para inserção de dados na tabela de endereco
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('Barra do Piraí', '27135-630', 'Caixa DÁgua Velha', 'Rua Francisco Franco', '925'); -- 1
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '5422-630', 'São Miguel Paulista', 'Rua Avelino Costa', '220'); -- 2
INSERT INTO ENDERECO(cidade, cep, bairro, rua, numero) VALUES ('São Paulo', '7544-521', 'Vila Ré', 'Rua Meire Ortolano', '28'); -- 3


-- Exemplo para inserção de dados na tabela de fornecedor
--INSERT INTO FORNECEDOR()
--SELECT contato.id, endereco.id
--FROM
-- É necessário criar as referências de FK de CONTATO e ENDERECO para cadastrar FORNECEDOR
-- veja: https://pt.stackoverflow.com/questions/335489/sql-como-faço-um-insert-into-em-uma-tabela-que-tem-fk
INSERT INTO FORNECEDOR(razao_social, nome_fantasia, email, descricao, contato, endereco)
VALUES ('Pedigree Fornecimento','Pedigree','pedigree@pedigree.com','Fornecedor Pedigree',3, 2);



-- Cadastro da Mercadoria 1
INSERT INTO FORNECEDOR(razao_social, nome_fantasia, email, descricao, contato, endereco)
VALUES ('DuBom Fornecimento','Rações DuBom','dubom@hotmail.com','Fornecedor Rações DuBom',5, 3);
INSERT INTO LOCAL(cep, setor, capacidade) VALUES ('76913-559', '13B', '10 Toneladas');
INSERT INTO LOTE(data_fabricacao, data_vencimento)
VALUES( parsedatetime('2020-10-17', 'yyyy-MM-dd'),parsedatetime('2022-10-17', 'yyyy-MM-dd') );
INSERT INTO MERCADORIA(nome, marca, descricao, fornecedor)
VALUES ('Magnus Adulto Frango e Vegetais', 'Magnus', 'Ração Seca, com grãos médios, com embalagens de 15kg a 25kg',1);
INSERT INTO ITEM_ESTOCADO(preco_compra, preco_venda, quantidade, local, lote, mercadoria)
VALUES (10.90, 11.90, 20, 1, 1, 1);
----------------------------------------------------------------------------------------------------------------------