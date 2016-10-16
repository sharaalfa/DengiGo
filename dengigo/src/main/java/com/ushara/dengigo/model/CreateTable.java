package com.ushara.dengigo.model;


public class CreateTable {
    private static final Logger log = Logger.getLogger("CreateTable");
    final String QUERY_CREATE_ROLE =
            "CREATE TABLE Role(\n" +
                    "id integer,\n" +
                    "roleName varchar(60),\n" +
                    "PRIMARY KEY(id)\n" +
                    ");";

    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTable(){
        try{
            jdbcTemplate.execute("DROP TABLE IF EXISTS Role");
            jdbcTemplate.execute(QUERY_CREATE_ROLE);
            log.info("table successfully created");
            return "table successfully created";
        } catch (Exception e){
            log.warning(e.getMessage());
            return e.toString();
        }
    }
}
