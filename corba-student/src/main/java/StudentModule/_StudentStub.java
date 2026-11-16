package StudentModule;

/**
 * Generated from Student.idl — Client stub for remote invocation.
 */
public class _StudentStub extends org.omg.CORBA.portable.ObjectImpl implements Student {

    private static String[] __ids = {"IDL:StudentModule/Student:1.0"};

    @Override
    public String[] _ids() {
        return (String[]) __ids.clone();
    }

    @Override
    public String getStudentName(int rollNo) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
            org.omg.CORBA.portable.OutputStream _out = _request("getStudentName", true);
            _out.write_long(rollNo);
            _in = _invoke(_out);
            String _result = _in.read_string();
            return _result;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
            _in = _ex.getInputStream();
            String _id = _ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
            return getStudentName(rollNo);
        } finally {
            _releaseReply(_in);
        }
    }

    @Override
    public String getBranch(int rollNo) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
            org.omg.CORBA.portable.OutputStream _out = _request("getBranch", true);
            _out.write_long(rollNo);
            _in = _invoke(_out);
            String _result = _in.read_string();
            return _result;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
            _in = _ex.getInputStream();
            String _id = _ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
            return getBranch(rollNo);
        } finally {
            _releaseReply(_in);
        }
    }
}
