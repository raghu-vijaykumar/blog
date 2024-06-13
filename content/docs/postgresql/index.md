+++
title = "PostgreSQL"
tags = [ "postgresql", "database" ]
author = "Me"
showToc = true
TocOpen = false
draft = false
hidemeta = false
comments = false
disableShare = false
disableHLJS = false
hideSummary = false
searchHidden = true
ShowReadingTime = true
ShowBreadCrumbs = true
ShowPostNavLinks = true
ShowWordCount = true
ShowRssButtonInSectionTermList = true
UseHugoToc = true

[cover]
image = "./postgresql_logo.png"
alt = "Image"
caption = "PostgreSQL"
relative = false
hidden = false
+++

![Logo](postgresql_logo.png)

# For Updates

[PostgreSQL Docs](https://www.postgresql.org/docs/13/index.html)
[PostgreSQL Community and Blog](https://planet.postgresql.org/)

# PostgreSQL

# Quickstart

## Install PostgreSQL

[Download and Install PostgreSQL Windows](https://www.postgresql.org/download/windows/)

> :exclamation: Note: PostgreSQL is installed as a service. :exclamation:

```sh
#login
psql -U postgres -h localhost -p 5432
```

# Data Types

Data type defines what values can be stored in a column. Features:

- Data Types are not immutable.
- Can be changed or reassigned.
- Can be converted to other data types in query executions.

## Numeric Types

## Date/Time Types

## Geometric Types

## Network Address Types

## Character Types

## Arrays

:exclamation: > Note: PostgreSQL using one based numbering, i.e, an array starts from 1. :exclamation:

### Creating Arrays

```sql
SELECT '{0,1,2}';
SELECT '{{0,1},{1,2}}';
SELECT ARRAY[0,1,2];
SELECT ARRAY[ARRAY[0,1],ARRAY[1,2]];
```

### Accessing Arrays

```sql
-- Accessing a specific element
WITH arr AS(SELECT ARRAY[0,1,2] int_arr) SELECT int_arr[1] FROM arr;
int_arr
---------
       0
(1 row)

-- splicing an array
WITH arr AS(SELECT ARRAY[0,1,2] int_arr) SELECT int_arr[1:2]FROM arr;
 int_arr
---------
 {0,1}
(1 row)
```

### Getting information about arrays

```sql
-- array dimensions
WITH arr AS(SELECT ARRAY[0,1,2] int_arr) SELECT ARRAY_DIMS(int_arr) FROM arr;
 array_dims
------------
 [1:3]
(1 row)

-- array length
WITH arr AS(SELECT ARRAY[0,1,2] int_arr) SELECT ARRAY_LENGTH(int_arr,1) FROM arr;
 array_length
--------------
            3
(1 row)

-- total number of elements across all dimensions
WITH arr AS(SELECT ARRAY[ARRAY[0,1],ARRAY[1,2]] int_arr) SELECT cardinality(int_arr) FROM arr;
 cardinality
-------------
           4
(1 row)
```

### Array Functions

# PSQL Commands

```sql
General
  \copyright             show PostgreSQL usage and distribution terms
  \crosstabview [COLUMNS] execute query and display results in crosstab
  \errverbose            show most recent error message at maximum verbosity
  \g [(OPTIONS)] [FILE]  execute query (and send results to file or |pipe);
                         \g with no arguments is equivalent to a semicolon
  \gdesc                 describe result of query, without executing it
  \gexec                 execute query, then execute each value in its result
  \gset [PREFIX]         execute query and store results in psql variables
  \gx [(OPTIONS)] [FILE] as \g, but forces expanded output mode
  \q                     quit psql
  \watch [SEC]           execute query every SEC seconds

Help
  \? [commands]          show help on backslash commands
  \? options             show help on psql command-line options
  \? variables           show help on special variables
  \h [NAME]              help on syntax of SQL commands, * for all commands

Query Buffer
  \e [FILE] [LINE]       edit the query buffer (or file) with external editor
  \ef [FUNCNAME [LINE]]  edit function definition with external editor
  \ev [VIEWNAME [LINE]]  edit view definition with external editor
  \p                     show the contents of the query buffer
  \r                     reset (clear) the query buffer
  \w FILE                write query buffer to file

Input/Output
  \copy ...              perform SQL COPY with data stream to the client host
  \echo [-n] [STRING]    write string to standard output (-n for no newline)
  \i FILE                execute commands from file
  \ir FILE               as \i, but relative to location of current script
  \o [FILE]              send all query results to file or |pipe
  \qecho [-n] [STRING]   write string to \o output stream (-n for no newline)
  \warn [-n] [STRING]    write string to standard error (-n for no newline)

Conditional
  \if EXPR               begin conditional block
  \elif EXPR             alternative within current conditional block
  \else                  final alternative within current conditional block
  \endif                 end conditional block

Informational
  (options: S = show system objects, + = additional detail)
  \d[S+]                 list tables, views, and sequences
  \d[S+]  NAME           describe table, view, sequence, or index
  \da[S]  [PATTERN]      list aggregates
  \dA[+]  [PATTERN]      list access methods
  \dAc[+] [AMPTRN [TYPEPTRN]]  list operator classes
  \dAf[+] [AMPTRN [TYPEPTRN]]  list operator families
  \dAo[+] [AMPTRN [OPFPTRN]]   list operators of operator families
  \dAp    [AMPTRN [OPFPTRN]]   list support functions of operator families
  \db[+]  [PATTERN]      list tablespaces
  \dc[S+] [PATTERN]      list conversions
  \dC[+]  [PATTERN]      list casts
  \dd[S]  [PATTERN]      show object descriptions not displayed elsewhere
  \dD[S+] [PATTERN]      list domains
  \ddp    [PATTERN]      list default privileges
  \dE[S+] [PATTERN]      list foreign tables
  \det[+] [PATTERN]      list foreign tables
  \des[+] [PATTERN]      list foreign servers
  \deu[+] [PATTERN]      list user mappings
  \dew[+] [PATTERN]      list foreign-data wrappers
  \df[anptw][S+] [PATRN] list [only agg/normal/procedures/trigger/window] functions
  \dF[+]  [PATTERN]      list text search configurations
  \dFd[+] [PATTERN]      list text search dictionaries
  \dFp[+] [PATTERN]      list text search parsers
  \dFt[+] [PATTERN]      list text search templates
  \dg[S+] [PATTERN]      list roles
  \di[S+] [PATTERN]      list indexes
  \dl                    list large objects, same as \lo_list
  \dL[S+] [PATTERN]      list procedural languages
  \dm[S+] [PATTERN]      list materialized views
  \dn[S+] [PATTERN]      list schemas
  \do[S]  [PATTERN]      list operators
  \dO[S+] [PATTERN]      list collations
  \dp     [PATTERN]      list table, view, and sequence access privileges
  \dP[itn+] [PATTERN]    list [only index/table] partitioned relations [n=nested]
  \drds [PATRN1 [PATRN2]] list per-database role settings
  \dRp[+] [PATTERN]      list replication publications
  \dRs[+] [PATTERN]      list replication subscriptions
  \ds[S+] [PATTERN]      list sequences
  \dt[S+] [PATTERN]      list tables
  \dT[S+] [PATTERN]      list data types
  \du[S+] [PATTERN]      list roles
  \dv[S+] [PATTERN]      list views
  \dx[+]  [PATTERN]      list extensions
  \dy     [PATTERN]      list event triggers
  \l[+]   [PATTERN]      list databases
  \sf[+]  FUNCNAME       show a function's definition
  \sv[+]  VIEWNAME       show a view's definition
  \z      [PATTERN]      same as \dp

Formatting
  \a                     toggle between unaligned and aligned output mode
  \C [STRING]            set table title, or unset if none
  \f [STRING]            show or set field separator for unaligned query output
  \H                     toggle HTML output mode (currently off)
  \pset [NAME [VALUE]]   set table output option
                         (border|columns|csv_fieldsep|expanded|fieldsep|
                         fieldsep_zero|footer|format|linestyle|null|
                         numericlocale|pager|pager_min_lines|recordsep|
                         recordsep_zero|tableattr|title|tuples_only|
                         unicode_border_linestyle|unicode_column_linestyle|
                         unicode_header_linestyle)
  \t [on|off]            show only rows (currently off)
  \T [STRING]            set HTML <table> tag attributes, or unset if none
Large Objects
  \lo_export LOBOID FILE
  \lo_import FILE [COMMENT]
  \lo_list
  \lo_unlink LOBOID      large object operations
```

# [Database](https://www.postgresql.org/docs/13/sql-createdatabase.html)

Command: CREATE DATABASE
Description: create a new database
Syntax:

```
CREATE DATABASE name
[ [ WITH ] [ OWNER [=] user_name ]
[ TEMPLATE [=] template ]
[ ENCODING [=] encoding ]
[ LOCALE [=] locale ]
[ LC_COLLATE [=] lc_collate ]
[ LC_CTYPE [=] lc_ctype ]
[ TABLESPACE [=] tablespace_name ]
[ ALLOW_CONNECTIONS [=] allowconn ]
[ CONNECTION LIMIT [=] connlimit ]
[ IS_TEMPLATE [=] istemplate ] ]
```

```sql
CREATE DATABASE airlines
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_India.1252'
    LC_CTYPE = 'English_India.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE postgres
    IS 'default administrative connection database';
```

# Tables

## Show tables definition

```sql
-- list all relations
\dSEL
            List of relations
 Schema |    Name     | Type  |  Owner
--------+-------------+-------+----------
 public | performance | table | postgres
 public | person      | table | postgres
(2 rows)

-- Table definition
\d person
                        Table "public.person"
   Column   |          Type          | Collation | Nullable | Default
------------+------------------------+-----------+----------+---------
 person_id  | bigint                 |           | not null |
 last_name  | character varying(255) |           | not null |
 first_name | character varying(255) |           |          |
 age        | integer                |           | not null |
Indexes:
    "person_pkey" PRIMARY KEY, btree (person_id)

-- Extended table definition
\d+ person
                                            Table "public.person"
   Column   |          Type          | Collation | Nullable | Default | Storage  | Stats target | Description
------------+------------------------+-----------+----------+---------+----------+--------------+-------------
 person_id  | bigint                 |           | not null |         | plain    |              |
 last_name  | character varying(255) |           | not null |         | extended |              |
 first_name | character varying(255) |           |          |         | extended |              |
 age        | integer                |           | not null |         | plain    |              |
Indexes:
    "person_pkey" PRIMARY KEY, btree (person_id)
Access method: heap
```

## [Create table](https://www.postgresql.org/docs/13/sql-createtable.html)

Command: CREATE TABLE
Description: define a new table
Syntax:

```
CREATE [ [ GLOBAL | LOCAL ] { TEMPORARY | TEMP } | UNLOGGED ] TABLE [ IF NOT EXISTS ] table_name ( [
{ column_name data_type [ COLLATE collation ] [ column_constraint [ ... ] ]
| table_constraint
| LIKE source_table [ like_option ... ] }
[, ... ]
] )
[ INHERITS ( parent_table [, ... ] ) ]
[ PARTITION BY { RANGE | LIST | HASH } ( { column_name | ( expression ) } [ COLLATE collation ] [ opclass ] [, ... ] ) ]
[ USING method ]
[ WITH ( storage_parameter [= value] [, ... ] ) | WITHOUT OIDS ]
[ ON COMMIT { PRESERVE ROWS | DELETE ROWS | DROP } ]
[ TABLESPACE tablespace_name ]

CREATE [ [ GLOBAL | LOCAL ] { TEMPORARY | TEMP } | UNLOGGED ] TABLE [ IF NOT EXISTS ] table_name
OF type_name [ (
{ column_name [ WITH OPTIONS ] [ column_constraint [ ... ] ]
| table_constraint }
[, ... ]
) ]
[ PARTITION BY { RANGE | LIST | HASH } ( { column_name | ( expression ) } [ COLLATE collation ] [ opclass ] [, ... ] ) ]
[ USING method ]
[ WITH ( storage_parameter [= value] [, ... ] ) | WITHOUT OIDS ]
[ ON COMMIT { PRESERVE ROWS | DELETE ROWS | DROP } ]
[ TABLESPACE tablespace_name ]

CREATE [ [ GLOBAL | LOCAL ] { TEMPORARY | TEMP } | UNLOGGED ] TABLE [ IF NOT EXISTS ] table_name
PARTITION OF parent_table [ (
{ column_name [ WITH OPTIONS ] [ column_constraint [ ... ] ]
| table_constraint }
[, ... ]
) ] { FOR VALUES partition_bound_spec | DEFAULT }
[ PARTITION BY { RANGE | LIST | HASH } ( { column_name | ( expression ) } [ COLLATE collation ] [ opclass ] [, ... ] ) ]
[ USING method ]
[ WITH ( storage_parameter [= value] [, ... ] ) | WITHOUT OIDS ]
[ ON COMMIT { PRESERVE ROWS | DELETE ROWS | DROP } ]
[ TABLESPACE tablespace_name ]
```

where column_constraint is:

```
[ CONSTRAINT constraint_name ]
{ NOT NULL |
NULL |
CHECK ( expression ) [ NO INHERIT ] |
DEFAULT default_expr |
GENERATED ALWAYS AS ( generation_expr ) STORED |
GENERATED { ALWAYS | BY DEFAULT } AS IDENTITY [ ( sequence_options ) ] |
UNIQUE index_parameters |
PRIMARY KEY index_parameters |
REFERENCES reftable [ ( refcolumn ) ] [ MATCH FULL | MATCH PARTIAL | MATCH SIMPLE ]
[ ON DELETE referential_action ] [ ON UPDATE referential_action ] }
[ DEFERRABLE | NOT DEFERRABLE ] [ INITIALLY DEFERRED | INITIALLY IMMEDIATE ]
```

and table_constraint is:

```
[ CONSTRAINT constraint_name ]
{ CHECK ( expression ) [ NO INHERIT ] |
UNIQUE ( column_name [, ... ] ) index_parameters |
PRIMARY KEY ( column_name [, ... ] ) index_parameters |
EXCLUDE [ USING index_method ] ( exclude_element WITH operator [, ... ] ) index_parameters [ WHERE ( predicate ) ] |
FOREIGN KEY ( column_name [, ... ] ) REFERENCES reftable [ ( refcolumn [, ... ] ) ]
[ MATCH FULL | MATCH PARTIAL | MATCH SIMPLE ] [ ON DELETE referential_action ] [ ON UPDATE referential_action ] }
[ DEFERRABLE | NOT DEFERRABLE ] [ INITIALLY DEFERRED | INITIALLY IMMEDIATE ]
```

and like_option is:

```
{ INCLUDING | EXCLUDING } { COMMENTS | CONSTRAINTS | DEFAULTS | GENERATED | IDENTITY | INDEXES | STATISTICS | STORAGE | ALL }
```

and partition_bound_spec is:

```
IN ( partition_bound_expr [, ...] ) |
FROM ( { partition_bound_expr | MINVALUE | MAXVALUE } [, ...] )
TO ( { partition_bound_expr | MINVALUE | MAXVALUE } [, ...] ) |
WITH ( MODULUS numeric_literal, REMAINDER numeric_literal )
```

index_parameters in UNIQUE, PRIMARY KEY, and EXCLUDE constraints are:

```
[ INCLUDE ( column_name [, ... ] ) ]
[ WITH ( storage_parameter [= value] [, ... ] ) ]
[ USING INDEX TABLESPACE tablespace_name ]
```

exclude_element in an EXCLUDE constraint is:

```
{ column_name | ( expression ) } [ opclass ] [ ASC | DESC ] [ NULLS { FIRST | LAST } ]
```

```sql
-- create a person table
CREATE [UNLOGGED] TABLE person (
	person_id BIGINT NOT NULL [PRIMARY KEY],
	last_name VARCHAR(255)NOT NULL,
	first_name VARCHAR(255),
	age INT NOT NULL,
	PRIMARY KEY(person_id)
);
-- An unlogged table skips writing a write ahead log, its not crash safe and cannot be replicated.
-- Primary key can also be column property or table property in create statement.

-- Create table from select statement
CREATE TABLE PEOPLE_OVER_30 AS
SELECT *
FROM PERSON
WHERE AGE > 30;

-- Create table referencing other table.
-- Agencies table id is referenced by users table.
CREATE TABLE AGENCIES (
  	ID SERIAL PRIMARY KEY,
	NAME TEXT NOT NULL
);


CREATE TABLE USERS (
	ID SERIAL PRIMARY KEY,
	AGENCY_ID INTEGER NOT NULL REFERENCES AGENCIES(ID) DEFERRABLE INITIALLY DEFERRED
);
```

### Drop Table

### Alter Table

### [Create Table as Select](https://www.postgresql.org/docs/13/sql-createtableas.html)

Description: define a new table from the results of a query
Syntax:

```
CREATE [ [ GLOBAL | LOCAL ] { TEMPORARY | TEMP } | UNLOGGED ] TABLE [ IF NOT EXISTS ] table_name
[ (column_name [, ...] ) ]
[ USING method ]
[ WITH ( storage_parameter [= value] [, ... ] ) | WITHOUT OIDS ]
[ ON COMMIT { PRESERVE ROWS | DELETE ROWS | DROP } ]
[ TABLESPACE tablespace_name ]
AS query
[ WITH [ NO ] DATA ]
```

# [Aggregates](https://www.postgresql.org/docs/13/sql-createaggregate.html)

Command: CREATE AGGREGATE
Description: define a new aggregate function
Syntax:

```
CREATE [ OR REPLACE ] AGGREGATE name ( [ argmode ] [ argname ] arg_data_type [ , ... ] ) (
SFUNC = sfunc,
STYPE = state_data_type
[ , SSPACE = state_data_size ]
[ , FINALFUNC = ffunc ]
[ , FINALFUNC_EXTRA ]
[ , FINALFUNC_MODIFY = { READ_ONLY | SHAREABLE | READ_WRITE } ]
[ , COMBINEFUNC = combinefunc ]
[ , SERIALFUNC = serialfunc ]
[ , DESERIALFUNC = deserialfunc ]
[ , INITCOND = initial_condition ]
[ , MSFUNC = msfunc ]
[ , MINVFUNC = minvfunc ]
[ , MSTYPE = mstate_data_type ]
[ , MSSPACE = mstate_data_size ]
[ , MFINALFUNC = mffunc ]
[ , MFINALFUNC_EXTRA ]
[ , MFINALFUNC_MODIFY = { READ_ONLY | SHAREABLE | READ_WRITE } ]
[ , MINITCOND = minitial_condition ]
[ , SORTOP = sort_operator ]
[ , PARALLEL = { SAFE | RESTRICTED | UNSAFE } ]
)

CREATE [ OR REPLACE ] AGGREGATE name ( [ [ argmode ] [ argname ] arg_data_type [ , ... ] ]
ORDER BY [ argmode ] [ argname ] arg_data_type [ , ... ] ) (
SFUNC = sfunc,
STYPE = state_data_type
[ , SSPACE = state_data_size ]
[ , FINALFUNC = ffunc ]
[ , FINALFUNC_EXTRA ]
[ , FINALFUNC_MODIFY = { READ_ONLY | SHAREABLE | READ_WRITE } ]
[ , INITCOND = initial_condition ]
[ , PARALLEL = { SAFE | RESTRICTED | UNSAFE } ]
[ , HYPOTHETICAL ]
)

or the old syntax

CREATE [ OR REPLACE ] AGGREGATE name (
BASETYPE = base_type,
SFUNC = sfunc,
STYPE = state_data_type
[ , SSPACE = state_data_size ]
[ , FINALFUNC = ffunc ]
[ , FINALFUNC_EXTRA ]
[ , FINALFUNC_MODIFY = { READ_ONLY | SHAREABLE | READ_WRITE } ]
[ , COMBINEFUNC = combinefunc ]
[ , SERIALFUNC = serialfunc ]
[ , DESERIALFUNC = deserialfunc ]
[ , INITCOND = initial_condition ]
[ , MSFUNC = msfunc ]
[ , MINVFUNC = minvfunc ]
[ , MSTYPE = mstate_data_type ]
[ , MSSPACE = mstate_data_size ]
[ , MFINALFUNC = mffunc ]
[ , MFINALFUNC_EXTRA ]
[ , MFINALFUNC_MODIFY = { READ_ONLY | SHAREABLE | READ_WRITE } ]
[ , MINITCOND = minitial_condition ]
[ , SORTOP = sort_operator ]
)
```

# [Casts](https://www.postgresql.org/docs/13/sql-createcast.html)

Command: CREATE CAST
Description: define a new cast
Syntax:

```
CREATE CAST (source_type AS target_type)
WITH FUNCTION function_name [ (argument_type [, ...]) ]
[ AS ASSIGNMENT | AS IMPLICIT ]

CREATE CAST (source_type AS target_type)
WITHOUT FUNCTION
[ AS ASSIGNMENT | AS IMPLICIT ]

CREATE CAST (source_type AS target_type)
WITH INOUT
[ AS ASSIGNMENT | AS IMPLICIT ]
```

# [Collation](https://www.postgresql.org/docs/13/sql-createcollation.html)

Command: CREATE COLLATION
Description: define a new collation
Syntax:

```
CREATE COLLATION [ IF NOT EXISTS ] name (
[ LOCALE = locale, ]
[ LC_COLLATE = lc_collate, ]
[ LC_CTYPE = lc_ctype, ]
[ PROVIDER = provider, ]
[ DETERMINISTIC = boolean, ]
[ VERSION = version ]
)
CREATE COLLATION [ IF NOT EXISTS ] name FROM existing_collation
```

# [Conversion](https://www.postgresql.org/docs/13/sql-createconversion.html)

Command: CREATE CONVERSION
Description: define a new encoding conversion
Syntax:

```
CREATE [ DEFAULT ] CONVERSION name
FOR source_encoding TO dest_encoding FROM function_name
```

# [Domain](https://www.postgresql.org/docs/13/sql-createdomain.html)

Command: CREATE DOMAIN
Description: define a new domain
Syntax:

```
CREATE DOMAIN name [ AS ] data_type
[ COLLATE collation ]
[ DEFAULT expression ]
[ constraint [ ... ] ]

where constraint is:

[ CONSTRAINT constraint_name ]
{ NOT NULL | NULL | CHECK (expression) }
```

# [Select](https://www.postgresql.org/docs/13/sql-select.html)

Command: SELECT
Description: retrieve rows from a table or view
Syntax:

```
[ WITH [ RECURSIVE ] with_query [, ...] ]
SELECT [ ALL | DISTINCT [ ON ( expression [, ...] ) ] ]
[ \* | expression [ [ AS ] output_name ] [, ...] ]
[ FROM from_item [, ...] ]
[ WHERE condition ]
[ GROUP BY grouping_element [, ...] ]
[ HAVING condition ]
[ WINDOW window_name AS ( window_definition ) [, ...] ]
[ { UNION | INTERSECT | EXCEPT } [ ALL | DISTINCT ] select ]
[ ORDER BY expression [ ASC | DESC | USING operator ] [ NULLS { FIRST | LAST } ] [, ...] ]
[ LIMIT { count | ALL } ]
[ OFFSET start [ ROW | ROWS ] ]
[ FETCH { FIRST | NEXT } [ count ] { ROW | ROWS } { ONLY | WITH TIES } ]
[ FOR { UPDATE | NO KEY UPDATE | SHARE | KEY SHARE } [ OF table_name [, ...] ] [ NOWAIT | SKIP LOCKED ] [...] ]

where from_item can be one of:

    [ ONLY ] table_name [ * ] [ [ AS ] alias [ ( column_alias [, ...] ) ] ]
                [ TABLESAMPLE sampling_method ( argument [, ...] ) [ REPEATABLE ( seed ) ] ]
    [ LATERAL ] ( select ) [ AS ] alias [ ( column_alias [, ...] ) ]
    with_query_name [ [ AS ] alias [ ( column_alias [, ...] ) ] ]
    [ LATERAL ] function_name ( [ argument [, ...] ] )
                [ WITH ORDINALITY ] [ [ AS ] alias [ ( column_alias [, ...] ) ] ]
    [ LATERAL ] function_name ( [ argument [, ...] ] ) [ AS ] alias ( column_definition [, ...] )
    [ LATERAL ] function_name ( [ argument [, ...] ] ) AS ( column_definition [, ...] )
    [ LATERAL ] ROWS FROM( function_name ( [ argument [, ...] ] ) [ AS ( column_definition [, ...] ) ] [, ...] )
                [ WITH ORDINALITY ] [ [ AS ] alias [ ( column_alias [, ...] ) ] ]
    from_item [ NATURAL ] join_type from_item [ ON join_condition | USING ( join_column [, ...] ) ]

and grouping_element can be one of:

    ( )
    expression
    ( expression [, ...] )
    ROLLUP ( { expression | ( expression [, ...] ) } [, ...] )
    CUBE ( { expression | ( expression [, ...] ) } [, ...] )
    GROUPING SETS ( grouping_element [, ...] )

and with_query is:

    with_query_name [ ( column_name [, ...] ) ] AS [ [ NOT ] MATERIALIZED ] ( select | values | insert | update | delete )

TABLE [ ONLY ] table_name [ * ]
```

# Querying Data

## Playground

the data in the dir airline is a data dump that can be resorted using the following command.

```sh
> pg_restore.exe --host "localhost" --port "5432" --username "postgres" --no-password --dbname "airlines" --format=d --verbose "C:\\Users\\raghu\\Desktop\\COMBIN~1\\airlines\\"
pg_restore: connecting to database for restore
pg_restore: creating TABLE "public.codes_cancellation"
pg_restore: creating TABLE "public.codes_carrier"
pg_restore: creating TABLE "public.perform_feb"
pg_restore: creating TABLE "public.performance"
pg_restore: processing data for table "public.codes_cancellation"
pg_restore: processing data for table "public.codes_carrier"
pg_restore: processing data for table "public.perform_feb"
pg_restore: processing data for table "public.performance"
```

## Aliasing

```sql
-- Aliasing select columns
SELECT mkt_carrier AS carrier, mkt_carrier_fl_num AS flight_number, origin FROM performance;
 carrier | flight_number | origin
---------+---------------+--------
 UA      | 2429          | EWR
 UA      | 2427          | LAS
 UA      | 2426          | SNA
 ..... many more rows
```

## Limiting

```sql
-- limiting number of entries
SELECT * FROM performance LIMIT 1;
  fl_date   | mkt_carrier | mkt_carrier_fl_num | origin | origin_city_name | origin_state_abr | dest | dest_city_name | dest_state_abr | dep_delay_new | arr_delay_new | cancelled | cancellation_code | diverted | carrier_delay | weather_delay | nas_delay | security_delay | late_aircraft_delay
------------+-------------+--------------------+--------+------------------+------------------+------+----------------+----------------+---------------+---------------+-----------+-------------------+----------+---------------+---------------+-----------+----------------+---------------------
 2018-01-01 | UA          | 2429               | EWR    | Newark, NJ       | NJ               | DEN  | Denver, CO     | CO             |             0 |             0 |         0 |                   |        0 |               |               |           |                |
(1 row)
```

## Distinct

```sql
-- selecting distinct values of a column
SELECT DISTINCT mkt_carrier FROM performance;
 mkt_carrier
-------------
 AS
 NK
 VX
 AA
 F9
 B6
 G4
 HA
 DL
 UA
 WN
(11 rows)

-- selecting distinct across multiple columns
SELECT DISTINCT mkt_carrier, origin as depart_city FROM performance;
 mkt_carrier | depart_city
-------------+-------------
 UA          | PIA
 NK          | OAK
 AA          | RDU
 UA          | ABQ
 DL          | CLE
 ..... 1176 rows
```

## Filtering

> :exclamation: Note: AND has higher operator precedence than OR. use appropriate parenthesis to reduce confusion. :exclamation:

```sql
 -- select all fields with a where condition
SELECT * FROM performance WHERE origin = 'EWR';
  fl_date   | mkt_carrier | mkt_carrier_fl_num | origin | origin_city_name | origin_state_abr | dest |         dest_city_name         | dest_state_abr | dep_delay_new | arr_delay_new | cancelled | cancellation_code | diverted | carrier_delay | weather_delay | nas_delay | security_delay | late_aircraft_delay
------------+-------------+--------------------+--------+------------------+------------------+------+--------------------------------+----------------+---------------+---------------+-----------+-------------------+----------+---------------+---------------+-----------+----------------+---------------------
 2018-01-01 | UA          | 2429               | EWR    | Newark, NJ       | NJ               | DEN  | Denver, CO                     | CO             |             0 |             0 |         0 ||        0 |               |               |           |                |
 2018-01-01 | UA          | 2415               | EWR    | Newark, NJ       | NJ               | PDX  | Portland, OR                   | OR             |             0 |             0 |         0 ||        0 |               |               |           |                |
 .... many more rows

 --select with complex where condition
 SELECT fl_date, mkt_carrier AS airline, mkt_carrier_fl_num AS flight, origin, dest FROM performance  WHERE origin = 'ORD' AND dest = 'BZN';
  fl_date   | airline | flight | origin | dest
------------+---------+--------+--------+------
 2018-01-01 | UA      | 1990   | ORD    | BZN
 2018-01-01 | UA      | 926    | ORD    | BZN
 2018-01-02 | UA      | 1990   | ORD    | BZN
 ... many more rows
 -- for not equal condition use <> or != and try out OR operator

  --select where value is in between a range - Lower and upper boundaries are inclusive
SELECT fl_date, mkt_carrier, mkt_carrier_fl_num, dep_delay_new, origin, dest FROM performance WHERE dep_delay_new BETWEEN 60 AND 120;
  fl_date   | mkt_carrier | mkt_carrier_fl_num | dep_delay_new | origin | dest
------------+-------------+--------------------+---------------+--------+------
 2018-01-01 | UA          | 2413               |            76 | ORD    | BTV
 2018-01-01 | UA          | 2411               |            72 | EWR    | SMF
 2018-01-01 | UA          | 2155               |            94 | IND    | ORD
 ... many more rows

-- select in only specific values list
SELECT fl_date, mkt_carrier, mkt_carrier_fl_num, dep_delay_new, origin, dest FROM performance WHERE dep_delay_new BETWEEN 60 AND 120 AND origin IN ('MKE', 'AZO');
  fl_date   | mkt_carrier | mkt_carrier_fl_num | dep_delay_new | origin | dest
------------+-------------+--------------------+---------------+--------+------
 2018-01-01 | UA          | 3824               |           107 | MKE    | ORD
 2018-01-01 | UA          | 3817               |            62 | AZO    | ORD
 2018-01-01 | UA          | 3790               |            97 | AZO    | ORD
 ... many more rows
 --- try out NOT BETWEEN and NOT IN operators
```

## Pattern Matching

```sql
-- select fields that a match a pattern with like
-- Matching single character
SELECT DISTINCT origin_city_name FROM performance  WHERE origin_city_name LIKE '____, KS';
 origin_city_name
------------------
 Hays, KS
(1 row)

-- Matching one or more characters
SELECT DISTINCT origin_city_name FROM performance  WHERE origin_city_name LIKE 'Fort%';
  origin_city_name
---------------------
 Fort Smith, AR
 Fort Myers, FL
 Fort Lauderdale, FL
 Fort Wayne, IN
(4 rows)
--- These wildcard _ and % can be used anywhere in match string

--- Pattern matching with both _ and %
SELECT DISTINCT origin_city_name FROM performance  WHERE origin_city_name LIKE '__________________, %';
    origin_city_name
------------------------
 Bloomington/Normal, IL
 Hattiesburg/Laurel, MS
 Sarasota/Bradenton, FL
(3 rows)

--- To not match a pattern using NOT LIKE
SELECT DISTINCT origin_city_name FROM performance  WHERE origin_city_name NOT LIKE '%Fort%';
          origin_city_name
------------------------------------
 Colorado Springs, CO
 Roanoke, VA
 Christiansted, VI
 .... many more rows
```

## Null Values

```sql
-- select fields that do not null values
SELECT fl_date, mkt_carrier AS airline, mkt_carrier_fl_num AS flight, cancellation_code FROM performance  WHERE cancellation_code IS NOT NULL;
  fl_date   | airline | flight | cancellation_code
------------+---------+--------+-------------------
 2018-01-01 | UA      | 2034   | B
 2018-01-01 | UA      | 864    | A
 2018-01-01 | UA      | 488    | B
 ... many more rows
```

## Performing Joins

![Joins Venn Diagram](./joins-venn-diagram.png)

### Inner Join

```sql
-- select all entries from performance table that has an entry in codes carrier table on mkt_carrier and carrier_code.
SELECT p.fl_date, p.mkt_carrier,cc.carrier_desc, p.mkt_carrier_fl_num as flight, p.origin, p.dest FROM performance p INNER JOIN codes_carrier cc ON p.mkt_carrier = cc.carrier_code;
 fl_date   | mkt_carrier |    carrier_desc    | flight | origin | dest
------------+-------------+--------------------+--------+--------+------
 2018-01-01 | UA          | United Air Lines   | 2429   | EWR    | DEN
 2018-01-01 | UA          | United Air Lines   | 2427   | LAS    | SFO
 2018-01-01 | UA          | United Air Lines   | 2426   | SNA    | DEN
 2018-01-01 | UA          | United Air Lines   | 2425   | RSW    | ORD
 ... many more rows
```

### Outer Join

#### Left Join

```sql
-- fetching only details of the flight that was cancelled
	SELECT P.FL_DATE,
	P.MKT_CARRIER,
	CA.CANCEL_DESC,
	P.MKT_CARRIER_FL_NUM AS FLIGHT,
	P.ORIGIN,
	P.DEST
FROM CODES_CANCELLATION CA
LEFT JOIN PERFORMANCE P ON P.CANCELLATION_CODE = CA.CANCELLATION_CODE;
  fl_date   | mkt_carrier |     cancel_desc     | flight | origin | dest
------------+-------------+---------------------+--------+--------+------
 2018-01-01 | UA          | Weather             | 2034   | IAH    | MFE
 2018-01-01 | UA          | Carrier             | 864    | LAS    | SFO
 2018-01-01 | UA          | Weather             | 488    | MFE    | IAH
```

#### Right Join

> :exclamation: Note: Use Left Join as a standard practice, until right join is absolutely necessary. :exclamation:

```sql
--- select all records from table B and joins with table A.
```

### Full Join

```sql
--- Selects all records from both the tables and performs join operation.
SELECT P.FL_DATE,
  P.MKT_CARRIER,
  CA.CANCEL_DESC,
  P.MKT_CARRIER_FL_NUM AS FLIGHT,
  P.ORIGIN,
  P.DEST
FROM CODES_CANCELLATION CA
FULL JOIN PERFORMANCE P ON P.CANCELLATION_CODE = CA.CANCELLATION_CODE;
  fl_date   | mkt_carrier |     cancel_desc     | flight | origin | dest
------------+-------------+---------------------+--------+--------+------
 2018-01-01 | UA          |                     | 2429   | EWR    | DEN
 2018-01-01 | UA          |                     | 2427   | LAS    | SFO
 2018-01-01 | UA          |                     | 2426   | SNA    | DEN
 2018-01-01 | UA          |                     | 2425   | RSW    | ORD
```

## Ordering

## Aggregate Functions

### Count

### Sum

### Min Max

```sql
-- select min and max deplay for an airport pair
SELECT ORIGIN,
	DEST,
	MAX(ARR_DELAY_NEW),
	MIN(ARR_DELAY_NEW)
FROM PERFORMANCE
WHERE ARR_DELAY_NEW IS NOT NULL
	AND ARR_DELAY_NEW > 0
GROUP BY ORIGIN,
	DEST
ORDER BY DEST;
origin | dest | max  | min
--------+------+------+------
 ATL    | ABE  |  281 |    1
 CLT    | ABE  |  181 |    1
 DTW    | ABE  |  353 |    1
 FLL    | ABE  |   89 |    1
 ORD    | ABE  |  195 |    2
 ... many more rows
```

### Average

```sql
-- Calculating AVG delay for flights that have delay > 0 ordering by most departure delay
SELECT p.mkt_carrier,
	cc.carrier_desc as airline,
	AVG(p.dep_delay_new) AS avg_dep_delay,
	AVG(p.arr_delay_new) AS avg_arr_delay
	FROM performance p
INNER JOIN codes_carrier cc
	ON cc.carrier_code = p.mkt_carrier
WHERE dep_delay_new > 0 AND arr_delay_new > 0
GROUP BY  p.mkt_carrier,
	cc.carrier_desc
ORDER BY avg_dep_delay desc;
 mkt_carrier |      airline       |    avg_dep_delay    |    avg_arr_delay
-------------+--------------------+---------------------+---------------------
 DL          | Delta Air Lines    | 70.5181465755953480 | 67.1188111500830718
 UA          | United Air Lines   | 66.0501955939880585 | 64.4807082561251802
 F9          | Frontier Airlines  | 65.9053406998158379 | 61.6850828729281768
 B6          | JetBlue Airways    | 64.9873220906590121 | 63.2437507475182394
 NK          | Spirit Air Lines   | 55.4537678207739308 | 53.5845213849287169
 G4          | Allegiant Air      | 52.6692737430167598 | 51.4497206703910615
 AA          | American Airlines  | 49.5509546633142139 | 49.0363793509860926
 AS          | Alaska Airlines    | 40.0871443089430894 | 39.2555894308943089
 VX          | Virgin America     | 39.9071691176470588 | 40.2012867647058824
 WN          | Southwest Airlines | 32.7705248760471876 | 29.0510172679090443
 HA          | Hawaiian Airlines  | 21.5402704291593180 | 23.5996472663139330
(11 rows)
```

### Filtering Aggregates - HAVING

```sql
-- Calculating AVG delay for flights that have delay > 0 and having more than 60 min avg delay and order by most departure delay
SELECT P.MKT_CARRIER,
	CC.CARRIER_DESC AS AIRLINE,
	AVG(P.DEP_DELAY_NEW) AS AVG_DEP_DELAY,
	AVG(P.ARR_DELAY_NEW) AS AVG_ARR_DELAY
FROM PERFORMANCE P
INNER JOIN CODES_CARRIER CC ON CC.CARRIER_CODE = P.MKT_CARRIER
WHERE DEP_DELAY_NEW > 0
	AND ARR_DELAY_NEW > 0
GROUP BY P.MKT_CARRIER,
	CC.CARRIER_DESC
HAVING AVG(P.DEP_DELAY_NEW) > 60
OR AVG(P.ARR_DELAY_NEW) > 60
ORDER BY AVG_DEP_DELAY DESC;
 mkt_carrier |      airline      |    avg_dep_delay    |    avg_arr_delay
-------------+-------------------+---------------------+---------------------
 DL          | Delta Air Lines   | 70.5181465755953480 | 67.1188111500830718
 UA          | United Air Lines  | 66.0501955939880585 | 64.4807082561251802
 F9          | Frontier Airlines | 65.9053406998158379 | 61.6850828729281768
 B6          | JetBlue Airways   | 64.9873220906590121 | 63.2437507475182394
(4 rows)
```

# String Functions

## Concatenation

```sql
-- Concatenate two string fields
SELECT carrier_code || ', ' || carrier_desc  AS carrier FROM codes_carrier;
        carrier
------------------------
 AA, American Airlines
 AS, Alaska Airlines
 B6, JetBlue Airways
 DL, Delta Air Lines
 F9, Frontier Airlines
 G4, Allegiant Air
 HA, Hawaiian Airlines
 NK, Spirit Air Lines
 UA, United Air Lines
 VX, Virgin America
 WN, Southwest Airlines
(11 rows)

-- Alternative syntax
SELECT CONCAT(carrier_code, ', ' , carrier_desc)  AS carrier FROM codes_carrier;

-- Concatenate multiple strings
SELECT CONCAT_WS(', ' ,carrier_code,  carrier_desc, 'USA')  AS carrier FROM codes_carrier;
           carrier
-----------------------------
 AA, American Airlines, USA
 AS, Alaska Airlines, USA
 B6, JetBlue Airways, USA
 DL, Delta Air Lines, USA
 F9, Frontier Airlines, USA
 G4, Allegiant Air, USA
 HA, Hawaiian Airlines, USA
 NK, Spirit Air Lines, USA
 UA, United Air Lines, USA
 VX, Virgin America, USA
 WN, Southwest Airlines, USA
(11 rows)
```

## Trim Functions

```sql
-- trim leading and trailing spaces from a string
SELECT TRIM(' radar ');
 btrim
-------
 radar
(1 row)

-- trim leading and trailing characters from a string
SELECT TRIM('r' FROM 'radar');
 btrim
-------
 ada
(1 row)

--trim leading characters from a string
postgres=# SELECT TRIM(LEADING 'ra' FROM 'radar');
 ltrim
-------
 dar
(1 row)

--trim trailing characters from a string
SELECT TRIM(TRAILING 'dr' FROM 'radar');
 rtrim
-------
 rada
(1 row)
-- Note d is not present in the string as trailing character only r is trimmed.
```

## String isolation

```sql
-- select left n characters from a string
SELECT LEFT('Pluralsight',6);
  left
--------
 Plural
(1 row)

-- select right n characters from a string
SELECT RIGHT('Pluralsight',6);
 right
--------
 lsight
(1 row)
```

## Sub String

> :exclamation: **Note**: Array index starts from 1 in PostgreSQL.:exclamation:

```sql
-- split string by a delimiter and return the string n corresponding to the index
SELECT SPLIT_PART('USA/DC/202','/',2);
 split_part
------------
 DC
(1 row)

--- select substring using from index and length
SELECT SUBSTRING('USA/DC/202',5,2);
 substring
-----------
 DC
(1 row)
-- Alternative syntax
SELECT SUBSTRING('USA/DC/202' FROM 5 FOR 2);
 substring
-----------
 DC
(1 row)

-- select substring using from index to end of string
SELECT SUBSTRING('USA/DC/202',5);
 substring
-----------
 DC/202
(1 row)

```

# Arithmetic Functions & Operators

```sql
-- Addition / Subtraction
SELECT 2 + 2;
4

-- Division (beaware of data types)
 SELECT 13 / 2;
6

-- Division with data type fix
SELECT 13 / 2::float;
6.5

-- Modulo  MOD(a,b) returns the remainder of the division of a by b
SELECT 15 % 1;
0

-- Power - POWER(base,exponent)
SELECT 12 ^ 2;
144

-- Square Root - SQRT(a)
SELECT |/5;
2.23606797749979

-- Absolute value - ABS(a)
SELECT @(36-45);
9
```

# Set Fucntions

SQL Set theory basics:

- Results of a query can be considered as a set.
- SQL sets have same number of columns and same data types.

![SQL Set Operations](./set-operations.png)

```sql
-- Union operation
-- return results of two queries.
-- Union filters all duplicate records


-- Union all returns all records


-- Intersect operation
-- Return result from two queries that are present in both.
-- Intersect filters all duplicate records


-- Intersect all returns all records


-- Except operation
-- Return result from two queries that appears only in left query
-- Except filters all duplicate records

-- Except all returns all records

```

# SubQuery

A nested query where the result of one query can be use in other query.

Types:

- Correlated Subquery
- Non-Correlated Subquery

Features:

- Advantageous to calculate aggregates on the fly.
- Membership questions can be used in subqueries.

## Non-Correlated Subquery

```sql
-- select flights that were cancelled due to weather
SELECT FL_DATE,
	MKT_CARRIER || ' ' || MKT_CARRIER_FL_NUM AS FLIGHT,
	ORIGIN,
	DEST
FROM PERFORMANCE
WHERE CANCELLED = 1
	AND CANCELLATION_CODE IN
		(SELECT CANCELLATION_CODE
			FROM CODES_CANCELLATION
			WHERE CANCEL_DESC = 'Weather');
fl_date   | flight  | origin | dest
------------+---------+--------+------
 2018-01-01 | UA 2034 | IAH    | MFE
 2018-01-01 | UA 488  | MFE    | IAH
 2018-01-01 | UA 4748 | ORD    | RAP
 2018-01-01 | UA 4640 | DSM    | ORD
 ... many more rows
```

## Correlated Subquery

A subquery that uses values from the primary query i.e, its evaluated for each row of the primary query.

```sql
-- select flights from ORD to RAP which had delay greater than average delay here subquery depends on A.ORIGIN.
SELECT CONCAT_WS(' ',A.MKT_CARRIER,A.MKT_CARRIER_FL_NUM) AS FLIGHT,
	A.ORIGIN,
	A.DEST,
	A.DEP_DELAY_NEW
FROM PERFORMANCE A
WHERE A.ORIGIN = 'ORD'
	AND A.DEST = 'RAP'
	AND A.DEP_DELAY_NEW >
		(SELECT AVG(DEP_DELAY_NEW)
			FROM PERFORMANCE
			WHERE DEP_DELAY_NEW > 0
				AND ORIGIN = A.ORIGIN);
flight  | origin | dest | dep_delay_new
---------+--------+------+---------------
 UA 4748 | ORD    | RAP  |           144
 UA 4748 | ORD    | RAP  |           124
 AA 3652 | ORD    | RAP  |            67
(3 rows)

-- Average delay for flights from ORD to RAP is
SELECT AVG(DEP_DELAY_NEW)
			FROM PERFORMANCE
			WHERE DEP_DELAY_NEW > 0
				AND ORIGIN = 'ORD'
47.25
```

# Common Table Expressions

Create result sets that can be referenced in subsequest queries

Types:

- Non Recursive CTE
- Recursive CTE

Features:

- Easier to read and interpret complex queries.
- Can be performance optimizations for correlated subqueries.

## Non Recursive CTE

```sql
-- list all the flights based with delay greater than average delay grouped by origin.
WITH AVG_DELAY_PER_ORIGIN AS
	(SELECT AVG(DEP_DELAY_NEW) AS DELAY, ORIGIN
		FROM PERFORMANCE
		WHERE DEP_DELAY_NEW > 0
		GROUP BY ORIGIN)
SELECT CONCAT_WS(' ',A.MKT_CARRIER,A.MKT_CARRIER_FL_NUM) AS FLIGHT,
	A.ORIGIN,
	A.DEST,
	A.DEP_DELAY_NEW
FROM PERFORMANCE A
INNER JOIN AVG_DELAY_PER_ORIGIN B
ON A.ORIGIN = B.ORIGIN
WHERE A.DEP_DELAY_NEW > B.DELAY;
flight  | origin | dest | dep_delay_new
---------+--------+------+---------------
 UA 4279 | EWR    | GSP  |            96
 UA 4303 | ORD    | GRR  |           101
 UA 4305 | PVD    | ORD  |           112
... many more rows
```

## Recursive CTE

> Note: In CTE we can optionally specify a column name which is seful in recursion.

```sql
--- recursively evaluate sum of % with itself till 25 is reached
WITH RECURSIVE SERIES(LIST_NUM) AS
	(SELECT 5
		UNION ALL SELECT LIST_NUM + 5
		FROM SERIES
		WHERE LIST_NUM + 5 <= 25 )
SELECT LIST_NUM
FROM SERIES;
 list_num
----------
        5
       10
       15
       20
       25
(5 rows)
```

# Pivot and Unpivot

These are used to transform one table into another

- Pivot - Rows into columns
- Unpivot - Columns into rows

```sql

```

# Window Functions

A window is a set of table rows over which a function is applied.

Features:

- Aggregagte functions can also be applied over window functions.
- Order of Evaluation
  - Evaluated after joins, groupings and having clause.
  - Evaluated same time as select statements.
  - To use others selections in a window functions
    - include selection in a subquery or CTE.
    - apply window function on the outer query.
- Cannot be used in WHERE or HAVINg clause.

## Row Number

Assigns sequential number to each row, the window is defined by OVER() clause.

```sql
--- list all distinct carriers with ROW_NUMBER assigned to each row
WITH DISTINCT_CARRIER AS
	(SELECT DISTINCT (MKT_CARRIER) AS CARRIER
		FROM PERFORMANCE)
SELECT ROW_NUMBER() OVER() AS SL,
	CARRIER
FROM DISTINCT_CARRIER;
sl | carrier
----+---------
  1 | AS
  2 | NK
  3 | VX
  4 | AA
  5 | B6
  6 | F9
  7 | G4
  8 | HA
  9 | DL
 10 | UA
 11 | WN
(11 rows)

-- list all distinct carriers with ROW_NUMBER assigned to each row with ordering
WITH DISTINCT_CARRIER AS
	(SELECT DISTINCT (MKT_CARRIER) AS CARRIER
		FROM PERFORMANCE)
SELECT ROW_NUMBER() OVER(ORDER BY CARRIER) AS SL,
	CARRIER
FROM DISTINCT_CARRIER;
 sl | carrier
----+---------
  1 | AA
  2 | AS
  3 | B6
  4 | DL
  5 | F9
  6 | G4
  7 | HA
  8 | NK
  9 | UA
 10 | VX
 11 | WN
(11 rows)

```

## Partition

```sql
-- list count of flights from a origin to dest across all carriers
SELECT DISTINCT ORIGIN,
	DEST,
	COUNT(*) OVER(PARTITION BY ORIGIN)
FROM PERFORMANCE
GROUP BY ORIGIN,
	DEST
ORDER BY ORIGIN DESC,
	DEST;
origin | dest | count
--------+------+-------
 YUM    | PHX  |     1
 YNG    | PIE  |     2
 YNG    | SFB  |     2
 YKM    | SEA  |     1
 YAK    | CDV  |     2
 YAK    | JNU  |     2
... many more rows
```

## Ranking

Ranking assigns sequential number to each row, however matching rows are matched the same.

Dense Rank is used to avoid gaps in ranking.

```sql
SELECT mkt_carrier,
       mkt_carrier_fl_num,
       origin,
       dest,
       arr_delay_new,
       Row_number()
         OVER(
           ORDER BY mkt_carrier_fl_num),
       Rank()
         OVER(
           ORDER BY arr_delay_new DESC) AS DELAY_RANK,
       Dense_rank()
         OVER(
           ORDER BY arr_delay_new DESC) AS DELAY_DENSE_RANK
FROM   performance
WHERE  arr_delay_new IS NOT NULL
       AND arr_delay_new > 0
       AND mkt_carrier = 'AA'
       AND origin = 'MCI'
       AND fl_date = '2018-01-16'
ORDER  BY arr_delay_new ASC;
 mkt_carrier | mkt_carrier_fl_num | origin | dest | arr_delay_new | row_number | delay_rank | delay_dense_rank
-------------+--------------------+--------+------+---------------+------------+------------+------------------
 AA          | 2640               | MCI    | DFW  |             1 |          3 |         10 |                8
 AA          | 5121               | MCI    | CLT  |             1 |         10 |         10 |                8
 AA          | 4586               | MCI    | MIA  |             8 |          7 |          8 |                7
 AA          | 1224               | MCI    | DFW  |             8 |          1 |          8 |                7
 AA          | 4604               | MCI    | DCA  |             9 |          8 |          7 |                6
 AA          | 248                | MCI    | ORD  |            12 |          2 |          5 |                5
 AA          | 2983               | MCI    | ORD  |            12 |          4 |          5 |                5
 AA          | 3456               | MCI    | ORD  |            16 |          6 |          4 |                4
 AA          | 4659               | MCI    | DCA  |            25 |          9 |          3 |                3
 AA          | 601                | MCI    | PHX  |            32 |         11 |          2 |                2
 AA          | 3135               | MCI    | ORD  |            90 |          5 |          1 |                1
(11 rows)
```

## Special values

FIRST_VALUE() and LAST_VALUE() are used to get the first and last value of a column.

```sql
SELECT DEST,
	LAST_VALUE(ARR_DELAY_NEW) OVER W,
	FIRST_VALUE (ARR_DELAY_NEW) OVER W
FROM PERFORMANCE
WHERE ARR_DELAY_NEW IS NOT NULL
	AND ARR_DELAY_NEW > 0 WINDOW W AS (PARTITION BY DEST);
--- Wierd result
```

## Lag and Lead

Lagging rows are the rows that occur before the current row.
Leading rows are the rows that occur after the current row.

Features:

- These are used in month to month or year over year analysis.

```sql
-- get daily count group by day and lag by 5 day in another column and delta over five days.
WITH DAILY_FLIGHT_COUNT AS
	(SELECT FL_DATE,
			COUNT(*) AS DAILY_COUNT
		FROM PERFORMANCE
		GROUP BY FL_DATE)
SELECT FL_DATE,
	DAILY_COUNT,
	LAG(DAILY_COUNT,
		5) OVER (ORDER BY FL_DATE) AS LAG_COUNT,
	DAILY_COUNT - LAG(DAILY_COUNT,
		5) OVER (ORDER BY FL_DATE) AS DELTA_COUNT
FROM DAILY_FLIGHT_COUNT
ORDER BY FL_DATE;
 fl_date   | daily_count | lag_count | delta_count
------------+-------------+-----------+-------------
 2018-01-01 |       19515 |           |
 2018-01-02 |       21672 |           |
 2018-01-03 |       20940 |           |
 2018-01-04 |       20980 |           |
 2018-01-05 |       21026 |           |
 2018-01-06 |       17484 |     19515 |       -2031
 2018-01-07 |       20812 |     21672 |        -860
 2018-01-08 |       21021 |     20940 |          81
 2018-01-09 |       19942 |     20980 |       -1038
 2018-01-10 |       20487 |     21026 |        -539
 2018-01-11 |       21151 |     17484 |        3667
 2018-01-12 |       21319 |     20812 |         507
 2018-01-13 |       16037 |     21021 |       -4984
 ... Rows till end of month
```

# Performance

## Explain and Analyse

### Select Query

```sql
EXPLAIN ANALYSE
SELECT *
FROM PUBLIC.PERFORMANCE;
"Seq Scan on performance  (cost=0.00..14614.61 rows=621461 width=84) (actual time=0.067..126.664 rows=621461 loops=1)"
"Planning Time: 0.068 ms"
"Execution Time: 224.380 ms"
```

- 0.00 (Planning/Startup cost).
- 14614.61 Query plan cost. (Total cost)
  - COST = `(disk pages read _ sequential page cost) + (rows scanned _ cpu tuple cost) = (8400 * 1.0) + (621461 * 0.01) = 14614.61`

```sql
SELECT RELPAGES AS "Disk Page Read",
RELTUPLES AS "Rows Scanned"
FROM PG_CLASS
WHERE RELNAME = 'performance'
```

- 621461 rows is the number of rows returned by the query. (Number of rows returned)
- 84 Bytes is the size of the returned rows. (Total size of data/number of returned rows)

## Indexing

Indexs are a way to speed up queries. But indexes also add overhead to the database system as a whole, so they should be used sensibly.

### Select with Where clause

```sql
EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE ORIGIN = 'EWR';
"Gather  (cost=1000.00..13890.08 rows=12533 width=84) (actual time=0.206..33.883 rows=12888 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Workers Planned: 2"
"  Workers Launched: 2"
"  ->  Parallel Seq Scan on public.performance  (cost=0.00..11636.78 rows=5222 width=84) (actual time=0.027..28.880 rows=4296 loops=3)"
"        Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"        Filter: ((performance.origin)::text = 'EWR'::text)"
"        Rows Removed by Filter: 202858"
"        Worker 0:  actual time=0.017..29.242 rows=4372 loops=1"
"        Worker 1:  actual time=0.021..29.648 rows=4217 loops=1"
"Planning Time: 0.044 ms"
"Execution Time: 36.007 ms"
```

Creating index on `origin` column is a good idea.

```sql
CREATE INDEX origin_idx ON PERFORMANCE (origin);
EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE ORIGIN = 'EWR';
"Bitmap Heap Scan on public.performance  (cost=141.56..9103.93 rows=12533 width=84) (actual time=0.676..17.586 rows=12888 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Recheck Cond: ((performance.origin)::text = 'EWR'::text)"
"  Heap Blocks: exact=2747"
"  ->  Bitmap Index Scan on origin_idx  (cost=0.00..138.42 rows=12533 width=0) (actual time=0.453..0.453 rows=12888 loops=1)"
"        Index Cond: ((performance.origin)::text = 'EWR'::text)"
"Planning Time: 0.161 ms"
"Execution Time: 19.913 ms"

EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE ORIGIN = 'EWR' AND DEST = 'PDX';
"Bitmap Heap Scan on public.performance  (cost=138.46..9132.16 rows=132 width=84) (actual time=1.256..5.416 rows=89 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Recheck Cond: ((performance.origin)::text = 'EWR'::text)"
"  Filter: ((performance.dest)::text = 'PDX'::text)"
"  Rows Removed by Filter: 12799"
"  Heap Blocks: exact=2747"
"  ->  Bitmap Index Scan on origin_idx  (cost=0.00..138.42 rows=12533 width=0) (actual time=0.864..0.865 rows=12888 loops=1)"
"        Index Cond: ((performance.origin)::text = 'EWR'::text)"
"Planning Time: 0.108 ms"
"Execution Time: 5.450 ms"

-- What happens if order of columns is changed?
EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE DEST = 'PDX' AND ORIGIN = 'EWR';

```

Creating index on `dest` column is a good idea.

```sql
CREATE INDEX dest_idx ON PERFORMANCE (dest);

EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE ORIGIN = 'EWR' AND DEST = 'PDX';
"Bitmap Heap Scan on public.performance  (cost=212.10..689.00 rows=132 width=84) (actual time=0.845..0.948 rows=89 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Recheck Cond: (((performance.dest)::text = 'PDX'::text) AND ((performance.origin)::text = 'EWR'::text))"
"  Heap Blocks: exact=89"
"  ->  BitmapAnd  (cost=212.10..212.10 rows=132 width=0) (actual time=0.833..0.834 rows=0 loops=1)"
"        ->  Bitmap Index Scan on dest_idx  (cost=0.00..73.36 rows=6525 width=0) (actual time=0.353..0.353 rows=6613 loops=1)"
"              Index Cond: ((performance.dest)::text = 'PDX'::text)"
"        ->  Bitmap Index Scan on origin_idx  (cost=0.00..138.42 rows=12533 width=0) (actual time=0.391..0.392 rows=12888 loops=1)"
"              Index Cond: ((performance.origin)::text = 'EWR'::text)"
"Planning Time: 0.211 ms"
"Execution Time: 0.976 ms"
```

### Index types

- B-tree: Balanced tree index useful for equality and range queries.
- Hash: Useful for equality, But index need to be built manually on crashes.
- Generalized inverted Index (GIN): Useful for Array or full text search.
- Genneralized search index (GIST): Useful for Geometric data and full text search.

### Index Optimization

```sql
EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE ORIGIN = 'EWR' AND DEP_DELAY_NEW > 0;
"Gather  (cost=1000.00..13682.63 rows=3985 width=84) (actual time=0.160..42.342 rows=4453 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Workers Planned: 2"
"  Workers Launched: 2"
"  ->  Parallel Seq Scan on public.performance  (cost=0.00..12284.13 rows=1660 width=84) (actual time=0.089..37.477 rows=1484 loops=3)"
"        Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"        Filter: ((performance.dep_delay_new > '0'::numeric) AND ((performance.origin)::text = 'EWR'::text))"
"        Rows Removed by Filter: 205669"
"        Worker 0:  actual time=0.048..37.040 rows=1307 loops=1"
"        Worker 1:  actual time=0.213..37.313 rows=1610 loops=1"
"Planning Time: 0.097 ms"
"Execution Time: 43.200 ms"
CREATE INDEX origin_idx ON PERFORMANCE (origin);

EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE ORIGIN = 'EWR' AND DEP_DELAY_NEW > 0;
"Bitmap Heap Scan on public.performance  (cost=139.42..9133.13 rows=3985 width=84) (actual time=0.774..6.846 rows=4453 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Recheck Cond: ((performance.origin)::text = 'EWR'::text)"
"  Filter: (performance.dep_delay_new > '0'::numeric)"
"  Rows Removed by Filter: 8435"
"  Heap Blocks: exact=2747"
"  ->  Bitmap Index Scan on origin_idx  (cost=0.00..138.42 rows=12533 width=0) (actual time=0.550..0.551 rows=12888 loops=1)"
"        Index Cond: ((performance.origin)::text = 'EWR'::text)"
"Planning Time: 0.160 ms"
"Execution Time: 7.614 ms"

-- Multicolumn index
-- Creating a new index on both columns
CREATE INDEX origin_dep_delay_new_idx ON PERFORMANCE (origin, dep_delay_new);

EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE ORIGIN = 'EWR' AND DEP_DELAY_NEW > 0;
"Bitmap Heap Scan on public.performance  (cost=93.27..7053.38 rows=3985 width=84) (actual time=0.671..2.903 rows=4453 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Recheck Cond: (((performance.origin)::text = 'EWR'::text) AND (performance.dep_delay_new > '0'::numeric))"
"  Heap Blocks: exact=1634"
"  ->  Bitmap Index Scan on origin_dep_delay_new_idx  (cost=0.00..92.27 rows=3985 width=0) (actual time=0.484..0.485 rows=4453 loops=1)"
"        Index Cond: (((performance.origin)::text = 'EWR'::text) AND (performance.dep_delay_new > '0'::numeric))"
"Planning Time: 0.170 ms"
"Execution Time: 3.582 ms"

DROP INDEX origin_dep_delay_new_idx;

-- Index order
-- Changing the order of index - Performance is slower
CREATE INDEX dep_delay_new_origin_idx ON PERFORMANCE (origin, dep_delay_new);

EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE ORIGIN = 'EWR' AND DEP_DELAY_NEW > 0;
"Bitmap Heap Scan on public.performance  (cost=139.42..9133.13 rows=3984 width=84) (actual time=0.646..5.768 rows=4453 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Recheck Cond: ((performance.origin)::text = 'EWR'::text)"
"  Filter: (performance.dep_delay_new > '0'::numeric)"
"  Rows Removed by Filter: 8435"
"  Heap Blocks: exact=2747"
"  ->  Bitmap Index Scan on origin_idx  (cost=0.00..138.42 rows=12533 width=0) (actual time=0.415..0.416 rows=12888 loops=1)"
"        Index Cond: ((performance.origin)::text = 'EWR'::text)"
"Planning Time: 0.252 ms"
"Execution Time: 6.501 ms"

-- Cover Index - Not useful in this case
CREATE INDEX cover_idx ON PERFORMANCE (fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name,
									  origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new,
									   arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay,
									   weather_delay, nas_delay, security_delay, late_aircraft_delay);
-- Useful when we have less number of columns in tables and it can minimize heap blocks scanned.
```

#### Unique Index and Primary Key

Primary key and unique columns already have indexes, even though its not visible in pg_admin UI.

```sql
DROP TABLE public.sample;

CREATE TABLE public.sample
(
    id integer NOT NULL,
    firstcol character varying(40) COLLATE pg_catalog."default",
    secondcol integer,
    CONSTRAINT sample_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

ALTER TABLE public.sample
    OWNER to postgres;

-- To check if there is already an index
SELECT *
FROM PG_INDEX
JOIN PG_CLASS AS C ON C.OID = PG_INDEX.INDEXRELID
WHERE PG_INDEX.INDRELID = 'sample'::REGCLASS;

-- verify creating multiple indexes on same column
CREATE INDEX id_idx on sample(id)

-- verify creating unique constraint
ALTER TABLE SAMPLE ADD CONSTRAINT FIRSTCOL_UNQ_CONSTRAINT UNIQUE (FIRSTCOL)

-- verify creating unique index on
CREATE UNIQUE INDEX FIRSTCOL_UNQ_IDX on sample(firstcol)
```

#### Case Insensitivity

```sql
SELECT *
FROM PUBLIC.PERFORMANCE WHERE origin_city_name = 'newark, NJ';

--- Making the query case insensitive
EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE lower(origin_city_name) = lower('newark, Nj');
"Gather  (cost=1000.00..13594.83 rows=3107 width=85) (actual time=0.205..75.207 rows=12888 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Workers Planned: 2"
"  Workers Launched: 2"
"  ->  Parallel Seq Scan on public.performance  (cost=0.00..12284.13 rows=1295 width=85) (actual time=0.096..70.928 rows=4296 loops=3)"
"        Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"        Filter: (lower((performance.origin_city_name)::text) = 'newark, nj'::text)"
"        Rows Removed by Filter: 202858"
"        Worker 0:  actual time=0.163..71.812 rows=4500 loops=1"
"        Worker 1:  actual time=0.084..71.995 rows=4401 loops=1"
"Planning Time: 0.080 ms"
"Execution Time: 77.392 ms"

CREATE INDEX ORIGIN_CITY_NAME_INDEX ON PERFORMANCE (ORIGIN_CITY_NAME)

-- verify index is not used for query
CREATE INDEX ORIGIN_CITY_NAME_CASE_INSENSITIVE_INDEX ON PERFORMANCE (LOWER(ORIGIN_CITY_NAME))

EXPLAIN (ANALYSE, VERBOSE) SELECT *
FROM PUBLIC.PERFORMANCE WHERE lower(origin_city_name) = lower('newark, Nj');
"Bitmap Heap Scan on public.performance  (cost=36.50..6177.88 rows=3107 width=85) (actual time=0.619..15.666 rows=12888 loops=1)"
"  Output: fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay"
"  Recheck Cond: (lower((performance.origin_city_name)::text) = 'newark, nj'::text)"
"  Heap Blocks: exact=2747"
"  ->  Bitmap Index Scan on origin_city_name_case_insensitive_index  (cost=0.00..35.73 rows=3107 width=0) (actual time=0.408..0.409 rows=12888 loops=1)"
"        Index Cond: (lower((performance.origin_city_name)::text) = 'newark, nj'::text)"
"Planning Time: 0.159 ms"
"Execution Time: 18.005 ms"
```

#### Partial Index

```sql
--- Creating partial index (based on usecase)
CREATE INDEX DEP_DEL_NEW_IDX ON PERFORMANCE (DEP_DELAY_NEW)
WHERE DEP_DELAY_NEW > 10;
```

### Index Maintenance

### Reinitialize Indexes

In case of heavy OLTP workload, lots of deletes, Reindex periodically.

```sql
REINDEX INDEX origin_idx;
REINDEX TABLE PERFORMANCE;

-- with pg_cron
SELECT cron.schedule('30 3 * * 6', $$REINDEX INDEX origin_idx$$);
```

## Populating Large Data

### Disable Auto Commit

- Wrap the query in transaction block

```sql
BEGIN;
-- Insert statements
COMMIT;
```

### Bulk Insert with COPY

- Drop indexs before bulk insert

```sql
--- Copying to a file
Copy (Select \* From performance) To 'performance.csv' With CSV DELIMITER ',' HEADER;

--- Loading from a file
COPY performance  From 'performance.csv' With CSV DELIMITER ',' HEADER;
```

- Perform `ANALYZE PERFORMANCE` after bulk insert. This will create statistics on the table, helps postgres optimizer engine to optimize query plans.

```sql
ANALYZE VERBOSE PERFORMANCE;
INFO:  analyzing "public.performance"
INFO:  "performance": scanned 8400 of 8400 pages, containing 621461 live rows and 0 dead rows; 30000 rows in sample, 621461 estimated total rows
ANALYZE

```

- Analyse tables once a week.

## Vacuuming Tables and Database

```sql
VACCUUM VERBOSE PERFORMANCE;
INFO:  vacuuming "public.performance"
INFO:  launched 2 parallel vacuum workers for index cleanup (planned: 2)
INFO:  "performance": found 0 removable, 7 nonremovable row versions in 1 out of 8400 pages
DETAIL:  0 dead row versions cannot be removed yet, oldest xmin: 514
There were 0 unused item identifiers.
Skipped 0 pages due to buffer pins, 0 frozen pages.
0 pages are entirely empty.
CPU: user: 0.00 s, system: 0.00 s, elapsed: 0.01 s.
INFO:  vacuuming "pg_toast.pg_toast_16396"
INFO:  "pg_toast_16396": found 0 removable, 0 nonremovable row versions in 0 out of 0 pages
DETAIL:  0 dead row versions cannot be removed yet, oldest xmin: 514
There were 0 unused item identifiers.
Skipped 0 pages due to buffer pins, 0 frozen pages.
0 pages are entirely empty.
CPU: user: 0.00 s, system: 0.00 s, elapsed: 0.00 s.
VACUUM

DELETE FROM PERFORMANCE WHERE DEP_DELAY_NEW > 10;

VACCUUM VERBOSE PERFORMANCE;
INFO:  vacuuming "public.performance"
INFO:  launched 2 parallel vacuum workers for index vacuuming (planned: 2)
INFO:  scanned index "dep_del_new_idx" to remove 472701 row versions
DETAIL:  CPU: user: 0.01 s, system: 0.00 s, elapsed: 0.01 s
INFO:  scanned index "origin_city_name_case_insensitive_index" to remove 472701 row versions
DETAIL:  CPU: user: 0.05 s, system: 0.00 s, elapsed: 0.08 s
INFO:  scanned index "origin_city_name_index" to remove 472701 row versions
DETAIL:  CPU: user: 0.04 s, system: 0.01 s, elapsed: 0.08 s
INFO:  "performance": removed 472701 row versions in 8399 pages
DETAIL:  CPU: user: 0.01 s, system: 0.00 s, elapsed: 0.01 s
INFO:  index "origin_city_name_index" now contains 148760 row versions in 546 pages
DETAIL:  472701 index row versions were removed.
0 index pages have been deleted, 0 are currently reusable.
CPU: user: 0.00 s, system: 0.00 s, elapsed: 0.00 s.
INFO:  index "origin_city_name_case_insensitive_index" now contains 148760 row versions in 546 pages
DETAIL:  472701 index row versions were removed.
0 index pages have been deleted, 0 are currently reusable.
CPU: user: 0.00 s, system: 0.00 s, elapsed: 0.00 s.
INFO:  index "dep_del_new_idx" now contains 124759 row versions in 345 pages
DETAIL:  0 index row versions were removed.
0 index pages have been deleted, 0 are currently reusable.
CPU: user: 0.00 s, system: 0.00 s, elapsed: 0.00 s.
INFO:  "performance": found 472701 removable, 148760 nonremovable row versions in 8400 out of 8400 pages
DETAIL:  0 dead row versions cannot be removed yet, oldest xmin: 515
There were 0 unused item identifiers.
Skipped 0 pages due to buffer pins, 0 frozen pages.
0 pages are entirely empty.
CPU: user: 0.09 s, system: 0.02 s, elapsed: 0.14 s.
INFO:  vacuuming "pg_toast.pg_toast_16396"
INFO:  "pg_toast_16396": found 0 removable, 0 nonremovable row versions in 0 out of 0 pages
DETAIL:  0 dead row versions cannot be removed yet, oldest xmin: 515
There were 0 unused item identifiers.
Skipped 0 pages due to buffer pins, 0 frozen pages.
0 pages are entirely empty.
CPU: user: 0.00 s, system: 0.00 s, elapsed: 0.00 s.
VACUUM
```

- Vacuum tables once a week.

```sql
VACUUM VERBOSE; -- Vacuum all tables
```
