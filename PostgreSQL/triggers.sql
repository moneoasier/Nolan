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
