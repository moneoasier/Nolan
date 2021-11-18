create or replace function copy_users()
returns trigger as 
$$ 
begin
	insert into app_users(email) values (new.login);
	return new;
end;
$$
language 'plpgsql';

create trigger app_newusers 
before insert on res_users
for each row 
execute procedure copy_users();




create or replace function drop_users()
returns trigger as 
$$ 
begin
	delete from app_users where email = old.login;
	retun old;
end;
$$
language 'plpgsql';

create trigger app_oldusers 
before delete on res_users
for each row 
execute procedure drop_users();




create or replace function drop_product(orl_id int, or_id int)
returns void as $$
declare
	price_old numeric;
	iva_old numeric;
	total_old numeric;

	price_new numeric;
	iva_new numeric;
	total_new numeric;
begin
	select price_subtotal,price_tax,price_total into price_old,iva_old,total_old from sale_order_line where id = orl_id;
	select amount_untaxed,amount_tax,amount_total into price_new,iva_new,total_new from sale_order where id = or_id;
	update sale_order set amount_untaxed = (price_new-price_old), amount_tax = (iva_new-iva_old),amount_total = (total_new-total_old) where id = or_id;
	delete from sale_order_line where id = orl_id; 
end;
$$ language 'plpgsql';




create or replace function update_order(or_id int)
returns void as $$
declare
	price_new numeric;
	iva_new numeric;
	total_new numeric;
begin
	select sum(price_subtotal),sum(price_tax),sum(price_total) into price_new,iva_new,total_new from sale_order_line where order_id = or_id;
	update sale_order set amount_untaxed = price_new, amount_tax = iva_new,amount_total = total_new where id = or_id;
end;
$$ language 'plpgsql';