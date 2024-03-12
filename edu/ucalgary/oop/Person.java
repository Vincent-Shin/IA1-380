package edu.ucalgary.oop;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String comments;
    private final String ENTRY_DATE;

    

    public Person(String firstName, String lastName, String ENTRY_DATE) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
    }
    
    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
    }


    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        if (!gender.matches("(?i)^(male|female|other)$")) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are male, female, or other.");
        }
        this.gender = gender.toLowerCase(); // Store in a consistent format
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }
}

