-- Table: gla_modulo

-- DROP TABLE gla_modulo;

CREATE TABLE gla_modulo
(
  mod_id_codigo integer NOT NULL, -- Código do módulo com sequencia
  mod_st_descricao character varying(50) NOT NULL, -- Descrição do módulo que aparece nas telas e menu
  mod_ch_ativo character(1) NOT NULL, -- Define se o módulo está ativo ou inativo
  mod_st_nome character varying(50) NOT NULL, -- Campo que define qual tela que o módulo chama.
  CONSTRAINT pk_modulo_in_codigo PRIMARY KEY (mod_id_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gla_modulo
  OWNER TO postgres;
COMMENT ON TABLE gla_modulo
  IS 'Tabela que contém as informações de sistemas para acesso.';
COMMENT ON COLUMN gla_modulo.mod_id_codigo IS 'Código do módulo com sequencia';
COMMENT ON COLUMN gla_modulo.mod_st_descricao IS 'Descrição do módulo que aparece nas telas e menu';
COMMENT ON COLUMN gla_modulo.mod_ch_ativo IS 'Define se o módulo está ativo ou inativo';
COMMENT ON COLUMN gla_modulo.mod_st_nome IS 'Campo que define qual tela que o módulo chama.';

-- Sequence: seq_modulocodigo

-- DROP SEQUENCE seq_modulocodigo;

CREATE SEQUENCE seq_modulocodigo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_modulocodigo
  OWNER TO postgres;
COMMENT ON SEQUENCE seq_modulocodigo
  IS 'sequence que gera o mod_in_codigo';


-- Table: gla_moduloitem

-- DROP TABLE gla_moduloitem;

CREATE TABLE gla_moduloitem
(
  mod_in_codigo integer NOT NULL, -- Forenkey da tabela gla_modulo
  mof_in_codigo integer NOT NULL, -- Define o código da funcção.
  mof_st_descricao character varying(50), -- Descrição da função
  mof_ch_ativo character(1), -- Define de está ativo ou inativo
  mof_st_nome character varying(50), -- Define o função a ser chamada pelo modulo. Este campo não apresenta ao usuario
  CONSTRAINT pk_modulo_moduloitem PRIMARY KEY (mod_in_codigo, mof_in_codigo),
  CONSTRAINT fk_mod_in_codigo FOREIGN KEY (mod_in_codigo)
      REFERENCES gla_modulo (mod_id_codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gla_moduloitem
  OWNER TO postgres;
COMMENT ON TABLE gla_moduloitem
  IS 'Tabela que define as funções do modulo (inclusão, alteração, exclusão, pesquisa)';
COMMENT ON COLUMN gla_moduloitem.mod_in_codigo IS 'Forenkey da tabela gla_modulo';
COMMENT ON COLUMN gla_moduloitem.mof_in_codigo IS 'Define o código da funcção.';
COMMENT ON COLUMN gla_moduloitem.mof_st_descricao IS 'Descrição da função';
COMMENT ON COLUMN gla_moduloitem.mof_ch_ativo IS 'Define de está ativo ou inativo';
COMMENT ON COLUMN gla_moduloitem.mof_st_nome IS 'Define o função a ser chamada pelo modulo. Este campo não apresenta ao usuario';


