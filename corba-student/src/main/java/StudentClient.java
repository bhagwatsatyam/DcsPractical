import StudentModule.Student;
import StudentModule.StudentHelper;

import org.omg.CORBA.ORB;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class StudentClient {

        public static void main(String[] args) {

                try {

                        // Disable GMBAL monitoring BEFORE any ORB code loads it
                        // This is critical for Java 17+ compatibility
                        System.setProperty("org.glassfish.gmbal.noop", "true");
                        System.setProperty("org.glassfish.gmbal.no.multipleUpperBoundsException", "true");

                        java.util.Properties props = new java.util.Properties();
                        props.setProperty("org.omg.CORBA.ORBClass",
                                        "com.sun.corba.ee.impl.orb.ORBImpl");
                        props.setProperty("org.omg.CORBA.ORBSingletonClass",
                                        "com.sun.corba.ee.impl.orb.ORBSingleton");

                        ORB orb = ORB.init(args, props);

                        // Check if student.ref exists
                        java.nio.file.Path refPath = java.nio.file.Paths.get("student.ref");
                        if (!Files.exists(refPath)) {
                                System.err.println("Error: 'student.ref' not found!");
                                System.err.println("Please start the server first in another terminal by running: .\\run-server.ps1");
                                return;
                        }

                        // Read server object reference
                        byte[] refBytes = Files.readAllBytes(refPath);
                        String objectReference = new String(refBytes, StandardCharsets.UTF_8);

                        // Convert string into CORBA object
                        org.omg.CORBA.Object obj = orb.string_to_object(objectReference);

                        // Convert to Student remote object
                        Student student = StudentHelper.narrow(obj);

                        int rollNo = 2;

                        System.out.println("=================================");
                        System.out.println("       CORBA Student Client");
                        System.out.println("=================================");

                        System.out.println("Connected to CORBA Server.");
                        System.out.println();

                        System.out.println("Roll Number : " + rollNo);

                        System.out.println(
                                        "Student Name: "
                                                        + student.getStudentName(rollNo));

                        System.out.println(
                                        "Branch      : "
                                                        + student.getBranch(rollNo));

                } catch (Exception e) {

                        System.out.println("Client Error:");
                        e.printStackTrace();
                }
        }
}
