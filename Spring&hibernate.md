### SPRING & HIBERNATE

#### 	Spring MVC

##### 	Form Tags

: Form tags will generate html for us



| Form Tags        | Description          |
| :--------------- | -------------------- |
| form:form        | main form Container  |
| form:input       | text field           |
| form:textarea    | multiline text field |
| form:checkbox    | check box            |
| form:radiobutton | radio buttons        |
| form:select      | drop down list       |
| more ...         |                      |

##### Data Binding :

- Spring MVC Form Tags can make use of data binding.
- Automatically setting / retrieve data from a java object / bean.



##### Web Page Structure

- JSP page with special Spring MVC Form Tags.

  - ```html
    <html>
        --regular html---
        -- Spring MVC Form Tags ---
        --- more Html -----
    </html>
    ```

- How to reference Spring MVC Form  Tags.

  - ```jsp
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    ```

  - 

