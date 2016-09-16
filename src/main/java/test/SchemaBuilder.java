/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author rezalt
 */
public class SchemaBuilder
{
    public static void main(String[] args)
    {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.schema-generation.database.action","drop-and-create");
        Persistence.generateSchema("JPAdbPU", properties);
    }
}
