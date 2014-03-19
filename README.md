# Booking Process source code for online4m platform

[online4m](https://www.online4m.com) is a service for design and execution of process driven online forms. 
Fast, simple and pragmatic business process development.

This repository contains source code for [*How to build process driven form, so that the customer can quickly and simply send the request and receive an answer.*](http://www.online4m.com/blog/articles/online4m-booking-process/).

## Installation procedure

### Step 1: download repository

  $ git clone https://github.com/zedar/online4m-booking-process.git

### Step 2: login into online4m

Login to your account in *online4m* service - [*online4m/Sign In*](http://online4m/login/auth).  
If you do not have account register new one - [*online4m/Sign Up*](http://online4m.com/usr/create).

### Step 3: create new project

### Step 4: import form definition

Open form definition editor by selecting *New/Form Design* in toolbar under *Navigation* panel. Then select *Serialize Form Design to JSON*.  

In the dialog *GUI serialized to JSON* replace json string with the content of file:

    form/BP_FORM.json file.

Save form by selecting *Save Form Design* from the toolbar under *Navigation* panel.

In the dialog *Save Form Design* select project name (as was created in *Step 3*), enter **BP_FORM** in *Code Name* and 
**Booking Form** in *Name* attribute.

Again, select *New/Form Design* option from the toolbar under *Navigation* panel. Then select *Serialize Form Design to JSON*.  

In the dialog *GUI serialization to JSON* replace json string with the content of file:

    form/BP_CONFIRM_REQ_FORM.json

Save form by selecting *Save Form Design* from the toolbar under *Navigation* panel.

In the dialog *Save Form Design* select project name (as was created in *Step 3*), enter **BP_CONFIRM_REQ_FORM** in *Code Name* and 
**Confirmation Request Form** in *Name* attribute.


### Step 5: import process definition

Open process definition designer by selecting *New/Process Design* in toolbar under *Navigation* panel. Then select *Serializa Process Design to JSON*.  

In the dialog *Process serialized to JSON* replace json string with the content of file:

    process/BP_PROCESS.json

Save process by selecting *Save Process Design* from the toolbar under *Navigation* panel. 

In the dialog *Save Process Design* select project name (as was created in *Step 3*), enter **BP_PROCESS** in *Code Name* attribute and
**Booking process** in the *Name* attribute.

### Step 6: import gui ruleset

Open code editor by selecting *New/Control Rule File* in toolbar under *Navigation* panel.  
Copy and paste source code into the editor from the file:

    ruleset/gui/BP_FORMRuleset.groovy

Save ruleset by selecting *Save Control Ruleset* from the toolbar under *Navigation* panel. 

In the dialog *Save Control Ruleset* select project name (as was create in *Step 3*), enter **BP_FORMRuleset** as *Code Name* attribute.

### Step 7: import process ruleset

Repeat steps from *Step 6* but copy and paste the content of the

    ruleset/process/BP_PROCESSRuleset.groovy

Use **BP_PROCESSRuleset** as file name.

### Step 8: try it

In **test/test.html** folder there is example page that displays first online form.
