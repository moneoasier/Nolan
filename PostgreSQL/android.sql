insert into sale_order(id,name,state,date_order,user_id,
partner_id,partner_invoice_id,partner_shipping_id,pricelist_id,currency_id,
invoice_status,amount_untaxed,amount_tax,amount_total,currency_rate,
company_id,team_id,picking_policy,warehouse_id,effective_date)
values (ID_OSIG,S_ULTIMO,"draft",now(),U_ID,
P_ID,P_ID,P_ID,1,1,
"no",PRECIO,IVA,PRECIO+IVA,1,
1,5,"direct",1,current_date());

insert into sale_order_line(id,order_id,name,"sequence",invoice_status,price_unit,price_subtotal,price_tax,price_total,price_reduce,price_reduce_taxinc,price_reduce_taxexcl,discount,product_id,product_uom_qty,product_uom,qty_delivered_method,qty_delivered,qty_delivered_manual,qty_to_invoice,qty_invoiced,untaxed_amount_invoiced,untaxed_amount_to_invoice,salesman_id,currency_id,company_id,order_partner_id,state,create_uid,create_date,write_uid,write_date)
values (ID_SIG,ID_OSIG,[P_DEFAULT_CODE]+P_NAME,10,"no",PRECIO_U,PRECIO,IVA,PRECIO+IVA,PRECIO,PRECIO,PRECIO+IVA,0,P_ID,P_QTY,1,"stock_move",0,0,P_QTY,0,0,PRECIO,U_ID,1,1,C_ID,"draft",0,U_ID,now(),U_ID,now());

insert into res_partner(id,name,create_date,display_name,lang,user_id,active,type,street,zip,city,email,phone,is_company,color,partner_share,commercial_partner_id,commercial_company_name,company_name,create_uid,write_uid,write_date)
values (ID_CSIG,C_NAME,now(),C_NAME,"es_ES",U_ID,true,C_DIR,C_POSTAL,C_CITY,C_EMAIL,C_PHONE,COMPANY?,0,true,U_ID,C_NAME,C_NAME,U_ID,U_ID,now());

select id from res_partner order by id desc limit 1;

select sale_order.id,sale_order.name,sale_order_line.id from sale_order inner join sale_order_line on order_id = sale_order.id order by sale_order.id desc, sale_order_line.id desc limit 1;

select product_template.default_code, product_template.name, product_template.list_price, sum(quantity - reserved_quantity), product_category.name as category from stock_quant"
+ "inner join product_template on product_template.id = stock_quant.product_id "
+ "inner join product_category on product_category.id = product_template.categ_id "
+ "where location_id = 8 "
+ "group by product_template.name, product_template.list_price, product_id, product_template.default_code, product_category.name "
+ "order by product_template.default_code";

moreno.manuel@uni.eus

ALTER SEQUENCE product_id_seq RESTART WITH 1453;

