package com.adaltas.examples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.io.compress.Compression;

import static org.junit.Assert.assertEquals;

//i have to import other libaries to enable me carryon with my work
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestCreateTableClass
{
    private final static String tableName = "deborahsTB";

    public static void main( String[] args ) throws Exception {

        //Start the "mini cluster"
        /*...*/

        List<Record> data = new ArrayList<Record>();
        List<Cluster> clusters = new ArrayList<Cluster>();
        Map<Cluster, List<Record>> clusterRecords = new HashMap<Cluster, List<Record>>();

        public static void main(String[] args){

            int clusterNumber = 2;
            deborahTB demo = new deborahTB();
            demo.genereateRecord();
            demo.initiateCluster(clusterNumber);
            demo.printRecordInformation();
            demo.printClusterInformation();
        }
        //Get the configuration
        //Configuration conf = ...
        private void genereateRecord() {
            Record record = new Record(10, 50, 15, 40);
            data.add(record);
            record = new Record(20, 21, 99, 81);
            data.add(record);
            record = new Record(30, 20, 16, 60);
            data.add(record);
            record = new Record(40, 23, 16, 77);
            data.add(record);
            record = new Record(50, 31, 17, 40);
            data.add(record);
            record = new Record(60, 22, 17, 76);
            data.add(record);

        }

        //Instantiate a connection
        Connection connection = ConnectionFactory.createConnection(conf);
        private void initiateCluster(int clusterNumber) {
            int counter = 1;
            Iterator<Record> iterator = data.iterator();
            Record record = null;

            while(iterator.hasNext()) {
                record = iterator.next();
                if(counter <= clusterNumber) {
                    record.setClusterNumber(counter);
                    initializeCluster(counter, record);
                    counter++;
                }else {
                    System.out.println(record);
                    System.out.println("** Cluster Information **");
                    for(Cluster cluster : clusters) {
                        System.out.println(cluster);
                    }
                    System.out.println("*********************");
                    double minScoreid = Integer.MAX_VALUE;
                    Cluster whichCluster = null;

                    for(Cluster cluster : clusters) {
                        double scoreid = cluster.calculatescoreid(record);
                        System.out.println(scoreid);
                        if(minScoreid > scoreid) {
                            minScoreid = scoreid;
                            whichCluster = cluster;
                        }
                    }
                    record.setClusterNumber(whichCluster.getClusterNumber());
                    whichCluster.updateCentroid(record);
                    clusterRecords.get(whichCluster).add(record);

                }

                System.out.println("** Cluster Information **");
                for(Cluster cluster : clusters) {
                    System.out.println(cluster);
                }
                System.out.println("*********************");


            }

        }

        //Define table "myTable"
        HTableDescriptor table = new HTableDescriptor(TableName.valueOf(tableName));
        table.addFamily(new HColumnDescriptor("cf1").setCompressionType(Compression.Algorithm.NONE));

        //Create table "myTable"
        connection.getAdmin().createTable(table);
        private void initializeCluster(int clusterNumber, Record record) {

            Cluster cluster = new Cluster(clusterNumber,record.getAge(),record.getIncome(),record.getScore());
            clusters.add(cluster);
            List<Record> clusterRecord = new ArrayList<Record>();
            clusterRecord.add(record);
            clusterRecords.put(cluster, clusterRecord);

        }

        //Get the first (and only) table name
        String first_table = connection.getAdmin().listTableNames()[0].getNameAsString();

        private void printRecordInformation() {
            System.out.println("****** Each Record INFORMATIN *********");
            for(Record record : data) {
                System.out.println(record);
            }
        }

        //Verify the returned Table name is equal to the table name we provided
        assertEquals(first_table,deborahTB);

        //Verify the returned value is equal to the value you created

        /*...*/
        private void printClusterInformation() {
            System.out.println("****** FINAL CLUSTER INFORMATIN *********");
            for (Map.Entry<Cluster, List<Record>> entry : clusterRecords.entrySet())  {
                System.out.println("Key = " + entry.getKey() +
                        ", Value = " + entry.getValue());
            }
        }


    }

        //Stop the mini cluster
        /*...*/
     return cluster;
    }
}
