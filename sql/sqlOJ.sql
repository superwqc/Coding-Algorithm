1.查找最晚入职员工的所有信息

CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

select * from employees where hire_date =(select Max(hire_date) from employees);

SELECT * FROM employees ORDER BY hire_date DESC LIMIT 0,1;


2.查找入职员工时间排名倒数第三的员工所有信息

CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

select * from employees order by hire_date desc limit 2,1;


3.查找各个部门当前(to_date='9999-01-01')领导当前薪水详情以及其对应部门编号dept_no

CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

select s.* ,d.dept_no from d,s 
where d.to_date='9999-01-01'
and s.to_date='9999-01-01'
and d.emp_no=s.emp.no;

4.查找所有已经分配部门的员工的last_name和first_name

CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

select d.first_name,last_name d.dept_no
from d,e
where d.emp_no=e.emp_no;

5.查找所有员工的last_name和first_name以及对应部门编号dept_no，也包括展示没有分配具体部门的员工

CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`)); 

select e.last_name,e.first_name,d.dept_no
from employees e left join dept_emp d
on d.emp_no=e.emp_no;


两个表连接时用on,在使用leftjion时，on和where条件的区别如下：
1、on条件是在生成临时表时使用的条件，它不管on中的条件是否为真，都会返回左边表中的记录。


2、where条件是在临时表生成好后，再对临时表进行过滤的条件。这时已经没有left?
join的含义（必须返回左边表的记录）了，条件不为真的就全部过滤掉。


6.查找所有员工入职时候的薪水情况，给出emp_no以及salary， 并按照emp_no进行逆序
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
连接查询
select e.emp_no,s.salary from employees e 
join salaries s
on e.emp_no =s.emp_no
and e.hire_date=s.from_date 
order by e.emp_no desc;
或并列查询
select e.emp_no,s.salary from employees e ,salaries s
where e.emp_no=s.emp_no and e.hire_date=s.from_date
order by e.emp_no desc; 

7.查找薪水涨幅超过15次的员工号emp_no以及其对应的涨幅次数t
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

select s.emp_no,count(s.emp_no)as t from salaries s
group by s.emp_no
having t > 15;

where 后不能跟count函数，所以用having

8.找出所有员工当前(to_date='9999-01-01')具体的薪水salary情况，对于相同的薪水只显示一次,并按照逆序显示
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

相同薪水显示一次，则使用SELECT DISTINCT可去除重复值
select distinct salary from salaries
where to_date='9999-01-01'
order by salary desc;

9.获取所有部门当前manager的当前薪水情况，给出dept_no, emp_no以及salary，当前表示to_date='9999-01-01'
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));


select d.dept_no,d.emp_no,s.salary 
from salaries s,dept_manager d
where d.emp_no=s.emp_no
and d.to_date='9999-01-01'
and s.to_date='9999-01-01';

10.获取所有非manager的员工emp_no
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

select e.emp_no from employees e
where e.emp_no not in (select emp_no from dept_manager);


11.获取所有员工当前的manager，如果当前的manager是自己的话结果不显示，当前表示to_date='9999-01-01'。
结果第一列给出当前员工的emp_no,第二列给出其manager对应的manager_no。
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

select de.emp_no ,dm.emp_no
from dept_emp de,dept_manager dm
where de.dept_no=dm.dept_no
and de.emp_no!=dm.emp_no
and de.to_date='9999-01-01'
and dm.to_date='9999-01-01';


12.获取所有部门中当前员工薪水最高的相关信息，给出dept_no, emp_no以及其对应的salary
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

select de.dept_no,s.emp_no,max(salary)
from dept_emp de,salaries s
where de.emp_no=s.emp_no
and de.to_date='9999-01-01'
and s.to_date='9999-01-01'
group by dept_no;

13.从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。
CREATE TABLE IF NOT EXISTS "titles" (
`emp_no` int(11) NOT NULL,
`title` varchar(50) NOT NULL,
`from_date` date NOT NULL,
`to_date` date DEFAULT NULL);

select title ,count(*)as n
from titles 
group by title
having n>=2;

14.从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。
注意对于重复的emp_no进行忽略。
CREATE TABLE IF NOT EXISTS "titles" (
`emp_no` int(11) NOT NULL,
`title` varchar(50) NOT NULL,
`from_date` date NOT NULL,
`to_date` date DEFAULT NULL);

select title ,count(distinct emp_no)as n
from titles
group by title
having n>=2;

15.查找employees表所有emp_no为奇数，且last_name不为Mary的员工信息，并按照hire_date逆序排列
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));


select * from employees
where emp_no % 2 =1
and last_name != 'Mary'
order by hire_date desc;

16.统计出当前各个title类型对应的员工当前薪水对应的平均工资。结果给出title以及平均工资avg。
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
CREATE TABLE IF NOT EXISTS "titles" (
`emp_no` int(11) NOT NULL,
`title` varchar(50) NOT NULL,
`from_date` date NOT NULL,
`to_date` date DEFAULT NULL);


select t.title,avg(s.salary)
from salaries s,titles t 
where t.emp_no=s.emp_no
and t.to_date='9999-01-01'
and s.to_date='9999-01-01'
group by title;


17.获取当前（to_date='9999-01-01'）薪水第二多的员工的emp_no以及其对应的薪水salary
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

select emp_no,salary 
from salaries 
order by salary desc
limit 1,1;


18.查找当前薪水(to_date='9999-01-01')排名第二多的员工编号emp_no、薪水salary、last_name以及first_name，不准使用order by
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));


select e.emp_no,max(s.salary),e.last_name,e.first_name
from employees e,salaries s
where e.emp_no=s.emp_no
and s.to_date='9999-01-01'
and salary not in (select max(salary) from salaries);


19.查找所有员工的last_name和first_name以及对应的dept_name，也包括暂时没有分配部门的员工
CREATE TABLE `departments` (
`dept_no` char(4) NOT NULL,
`dept_name` varchar(40) NOT NULL,
PRIMARY KEY (`dept_no`));
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));


select e.last_name,e.first_name,d.dept_name 
from employees e 
left join dept_emp de on e.emp_no =de.emp_no 
left join departments d on d.dept_no=de.dept_no;
第一次LEFT JOIN连接employees表与dept_emp表，得到所有员工的last_name和first_name以及对应的dept_no，也包括暂时没有分配部门的员工
第二次LEFT JOIN连接上表与departments表，即连接dept_no与dept_name，得到所有员工的last_name和first_name以及对应的dept_name，也包括暂时没有分配部门的员工


20.查找员工编号emp_now为10001其自入职以来的薪水salary涨幅值growth
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

select max(salary)-min(salary) as growth
from salaries 
where emp_no =10001;


21.查找所有员工自入职以来的薪水涨幅情况，给出员工编号emp_noy以及其对应的薪水涨幅growth，并按照growth进行升序
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

select t1.emp_no, t1.salary - t2.salary as growth
from 
(select e.emp_no,s.salary from salaries s,employees e where e.emp_no=s.emp_no and s.to_date='9999-01-01' )as t1,
(select e.emp_no,s.salary from salaries s,employees e where e.emp_no=s.emp_no and s.from_date=e.hire_date)as t2
where t1.emp_no=t2.emp_no 
order by growth;

22.统计各个部门对应员工涨幅的次数总和，给出部门编码dept_no、部门名称dept_name以及次数sum
CREATE TABLE `departments` (
`dept_no` char(4) NOT NULL,
`dept_name` varchar(40) NOT NULL,
PRIMARY KEY (`dept_no`));
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

解法1：
select d.dept_no,d.dept_name,count(salary)
from departments d,dept_emp de ,salaries s
where d.dept_no=de.dept_no
and de.emp_no=s.emp_no
group by d.dept_no;

解法2：本题关键是要将 每个部门分组，并分别统计工资记录总数，思路如下：
1、用INNER JOIN连接dept_emp表和salaries表，并以dept_emp.no分组，统计每个部门所有员工工资的记录总数
2、再将上表用INNER JOIN连接departments表，限制条件为两表的dept_no相等，找到dept_no与dept_name的对应关系，最后依次输出dept_no、dept_name、sum

SELECT de.dept_no, dp.dept_name, COUNT(s.salary) AS sum 
FROM (dept_emp AS de INNER JOIN salaries AS s ON de.emp_no = s.emp_no) 
INNER JOIN departments AS dp ON de.dept_no = dp.dept_no 
GROUP BY de.dept_no


23.对所有员工的当前(to_date='9999-01-01')薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));