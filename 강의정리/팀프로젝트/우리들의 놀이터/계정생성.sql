create user ShoppingMall IDENTIFIED BY jsp;

rollback;

select *
from ALL_users;

grant CONNECT, RESOURCE, dba to shoppingmall;