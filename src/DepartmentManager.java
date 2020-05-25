public class DepartmentManager {

    private Department[] departments;
    int capacity;
    int size;
    private final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_SIZE = 0;


    public DepartmentManager() {
        departments = new Department[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = DEFAULT_SIZE;
    }

    public DepartmentManager(int initialCapacity) {
        departments = new Department[initialCapacity];
        capacity = initialCapacity;
        size = DEFAULT_SIZE;
    }

    public DepartmentManager(Department[] departments) {
        Department[] newDepartments = new Department[departments.length];
        System.arraycopy(departments, 0, newDepartments, 0, departments.length);
        this.departments = newDepartments;
        size = departments.length;
    }

    public boolean add(Department department) {
        if (size == capacity) {
            Department[] newDepartments = new Department[capacity * 2];
            capacity *= 2;
            System.arraycopy(departments, 0, newDepartments, 0, departments.length);
            departments = newDepartments;
        }

        for (int i = 0; i < departments.length; i++) {
            if (departments[i] == null) {
                departments[i] = department;
                size++;
                return true;
            }
        }

        return false;
    }

    public boolean insert(Department department, int position){
        System.arraycopy(departments, position, departments, position + 1, size - position);
        departments[position] = department;
        return true;
    }

    public Department get(int position){
        return departments[position];
    }

    public Department get(String name){
        for (int i = 0; i < size; i++) {
            if (departments[i].getName().equalsIgnoreCase(name))
                return departments[i];
        }

        return null;
    }

    public Department rewrite(Department department, int position){
        Department oldDepartment = departments[position];
        departments[position] = department;
        return oldDepartment;
    }

    public Department delete(int position){
        Department deleted = departments[position];
        System.arraycopy(departments, position + 1, departments, position, size - position);
        departments[size--] = null;
        return deleted;
    }

    public Department delete(String name){
        for (int i = 0; i < size; i++) {
            if (departments[i].getName().equalsIgnoreCase(name))
            {
                Department deleted = departments[i];
                System.arraycopy(departments, i + 1, departments, i, size - i);
                departments[size--] = null;
                return deleted;
            }
        }

        return null;
    }

    public int getSize() {
        return size;
    }

    public Department[] getDepartments(){
        Department[] out = new Department[size];
        System.arraycopy(departments, 0, out, 0, size);
        return out;
    }
}
