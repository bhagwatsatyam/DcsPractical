package StudentModule;

/**
 * Generated from Student.idl — Holder class.
 */
public final class StudentHolder implements org.omg.CORBA.portable.Streamable {

    public Student value = null;

    public StudentHolder() {
    }

    public StudentHolder(Student initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = StudentHelper.narrow(i.read_Object(_StudentStub.class));
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        o.write_Object((org.omg.CORBA.Object) value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return org.omg.CORBA.ORB.init().create_interface_tc(StudentHelper.id(), "Student");
    }
}
