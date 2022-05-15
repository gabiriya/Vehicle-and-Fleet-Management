-- insert driver
insert into driver
values (111, '2000-01-01', 'jamal', 'alfa');
insert into driver
values (222, '1998-05-06', 'youssef', 'pedri');
insert into driver
values (333, '1995-09-12', 'amin', 'zer');
insert into driver
values (444, '1999-05-05', 'rabii', 'kati');

-- insert vehicle
insert into vehicle
values (10, 'audi', 120, '2015-01-10', 70, '2005-01-01', 111);
insert into vehicle
values (11, 'BMW', 160, '2018-05-02', 88, '2009-01-01', 111);
insert into vehicle
values (12, 'audi', 155, '2017-01-10', 75, '2008-01-01', 222);
insert into vehicle
values (14, 'Ferrari', 100, '2018-08-02', 95, '2010-01-01', 222);
insert into vehicle
values (13, 'Peugeot', 120, '2020-07-07', 60, '2016-01-01', 222);
insert into vehicle
values (15, 'ONO', 100, '2021-10-12', 50, '2002-01-01', 333);
insert into vehicle
values (16, 'clio', 12, '2015-01-10', 60, '2007-01-02', 444);
insert into vehicle
values (17, 'mercedes', 12, '2015-01-10', 85, '2013-01-01', 444);
insert into vehicle
values (18, 'Bugatti', 12, '2015-01-10', 100, '2009-01-03', 222);
insert into vehicle
values (19, 'Audi', 12, '2015-01-10', 65, '2005-01-08', 333);
insert into vehicle
values (20, 'Dacia', 12, '2015-01-10', 45, '2011-01-01', 444);

-- insert Insurance
insert into insurance
values (100, '2020-05-05', '2022-05-05', 'AXA', 10);
insert into insurance
values (101, '2021-01-01', '2022-01-01', 'AXA', 11);
insert into insurance
values (102, '2022-08-08', '2023-08-08', 'AXA', 12);
insert into insurance
values (103, '2021-02-15', '2022-02-15', 'AXA', 13);
insert into insurance
values (104, '2021-09-22', '2022-09-22', 'AXA', 14);
insert into insurance
values (105, '2021-12-09', '2022-12-09', 'AXA', 15);
insert into insurance
values (106, '2022-04-05', '2023-04-05', 'AXA', 16);
insert into insurance
values (107, '2021-11-10', '2022-11-10', 'AXA', 17);
insert into insurance
values (108, '2021-01-05', '2022-01-05', 'AXA', 18);
insert into insurance
values (109, '2022-05-05', '2022-05-05', 'AXA', 19);

-- insert maintenance
insert into maintenance
values (200, 120.0, 3, 5000, 'vidange', 'MONTH');
insert into maintenance
values (201, 500.0, 1, 5000, 'liquide de frein', 'YEAR');
insert into maintenance
values (202, 250.0, 3, 5000, 'vidange', 'MONTH');
insert into maintenance
values (203, 300.0, 1, 5000, 'vidange', 'MONTH');
insert into maintenance
values (204, 50.0, 1, 5000, 'contrôle des freins', 'MONTH');
insert into maintenance
values (205, 190.0, 3, 5000, 'vidange', 'MONTH');
insert into maintenance
values (206, 1000.0, 3, 5000, 'vidange', 'MONTH');
insert into maintenance
values (207, 210.0, 1, 5000, 'contrôle des essuie-glaces', 'YEAR');
insert into maintenance
values (208, 250.0, 3, 5000, 'vidange', 'MONTH');
insert into maintenance
values (209, 700.0, 3, 5000, 'vidange', 'MONTH');

-- insert maintenance vehicle
insert into maintenance_vehicle
values (1000, '2022-01-01', 1000);
insert into maintenance_vehicle
values (1001, '2022-01-01', 500);
insert into maintenance_vehicle
values (1002, '2022-01-01', 5000);
insert into maintenance_vehicle
values (1003, '2022-01-01', 700);
insert into maintenance_vehicle
values (1004, '2022-01-01', 150);
insert into maintenance_vehicle
values (1005, '2022-01-01', 4000);
insert into maintenance_vehicle
values (1006, '2022-01-01', 1000);
insert into maintenance_vehicle
values (1007, '2022-01-01', 1200);


