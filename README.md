# Booking Process source code for online4m platform

[online4m](http://online4m.com) provides process driven online forms. 
Fast, simple and pragmatic business process development.

This repository contains source code for [*How to build process driven form, so that the customer can quickly and simply send the request and receive an answer.*](http://blog.online4m.com/articles/online4m-reservation-process/).

## Installation procedure

### Step 1: download repository

  $ git clone 

### Step 2: login into online4m

Login to your account in *online4m* service - [*online4m/Sign In*](http://online4m/login/auth).  
If you do not have account register new one - [*online4m/Sign Up*](http://online4m.com/usr/create).

### Step 3: create new project

### Step 4: import form definition

Open form definition editor by selecting *New/Form Design* in toolbar under *Navigation* panel. Then select *Serialize Form Design to JSON*.  
Popup dialog with *title* **GUI serialization to JSON** should be visible.
Replace json string with content of the **form/BP_FORM.json** file.  
Save form by selecting *Save Form Design* from the toolbar.
New popup dialog should be visible.  
Select the project name created in step 3. Enter *Code Name* **BP_FORM**, the *Name* **Booking Form**.

Open new form definiton editor by selecting *New/Form Design*. Then *Serialize Form Design to JSON*.  
Change json with content of **form/BP_CONFIRM_REQ_FORM.json**.  
Save form and in popup select *Project* as previously.  Enter *Code Name* **BP_CONFIRM_REQ_FORM** and the *Name* **Request Confirmation Form**.

### Step 5: import process definition

Open process definition designer by selecting *New/Process Design* in toolbar under *Navigation* panel. Then select *Serializa Process Design to JSON*.  
Replace json string with content of the *process/BP_PROCESS.json*.  
Save process by selecting *Save Process Design* from the toolbar. In the *Save Process Design* dialog choose **Booking project** as Project attribute. 
**BP_PROCESS** as *Code Name* and **Booking process** as the *Name* attribute.

### Step 6: import gui ruleset

Open code editor by selecting *New/Control Rule File* in toolbar under *Navigation* panel.  
Copy and paste content of the *ruleset/gui/BP_FORMRuleset.groovy* file into the editor.  
Save ruleset by selecting *Sace Control Rule File* from the toolbar. In the *Save Control Rule File* dialog choose **Booking project** as Project attribute.
Save control ruleset by selecting *Save Control Rule File* option from the toolbar. In the *Save Control Ruleset* form choose **Booking project**. As *Code Name* enter **BP_FORMRuleset**.

### Step 7: import process ruleset

Repeat steps from *Step 6* but copy and paste the content of *ruleset/process/BP_PROCESSRuleset.groovy*, and use *BP_PROCESSRuleset* as file name.

### Step 8: try it

In *test/test.html* folder there is example page that displays first online form.
