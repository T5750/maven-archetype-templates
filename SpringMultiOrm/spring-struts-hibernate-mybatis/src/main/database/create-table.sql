-- Create table
create table T_ORDER
(
  id         NUMBER not null,
  clientname VARCHAR2(100),
  amount     NUMBER,
  createtime DATE
);
-- Add comments to the columns 
comment on column T_ORDER.id
  is '流水号';
comment on column T_ORDER.clientname
  is '客户名称';
comment on column T_ORDER.amount
  is '数量';
comment on column T_ORDER.createtime
  is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_ORDER
  add constraint PK_ORDER primary key (ID);
  
-- Create sequence 
create sequence SEQ_ORDER
minvalue 1
maxvalue 9999999999999999999999999
start with 1
increment by 1
cache 200;