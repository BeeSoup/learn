package com.zhang.spring.jsp.entity;

public class UserTable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_table.id
     *
     * @mbg.generated Sat Dec 14 21:28:19 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_table.name
     *
     * @mbg.generated Sat Dec 14 21:28:19 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_table.age
     *
     * @mbg.generated Sat Dec 14 21:28:19 CST 2019
     */
    private Integer age;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_table.id
     *
     * @return the value of user_table.id
     *
     * @mbg.generated Sat Dec 14 21:28:19 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_table.id
     *
     * @param id the value for user_table.id
     *
     * @mbg.generated Sat Dec 14 21:28:19 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_table.name
     *
     * @return the value of user_table.name
     *
     * @mbg.generated Sat Dec 14 21:28:19 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_table.name
     *
     * @param name the value for user_table.name
     *
     * @mbg.generated Sat Dec 14 21:28:19 CST 2019
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_table.age
     *
     * @return the value of user_table.age
     *
     * @mbg.generated Sat Dec 14 21:28:19 CST 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_table.age
     *
     * @param age the value for user_table.age
     *
     * @mbg.generated Sat Dec 14 21:28:19 CST 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}