The project is about hotel automation control system where we try controlling the lights and AC's system to be switched off or on based on the input and based on bill calculation for floor.This project is developed in core java with basic design patters knowledge and spring boot and MQTT can be used with time constraint.
Prerequisites:
	1.AC's will be on and are separately controllable and for them control is normal switch on and off and not much elaborated as of now.
	2.Lights are switched off or on on based on input.
	3. While switching on the light if we are crossing stipulated bill for floor then we will switch off the sub corridor AC and recheck again to switch on the light.
	
Following are the design patterns and instructions to be used
1.Builder pattern for building immutable pojo's
2.Singleton pattern for creating one instance of specific required class
3.Factory pattern for extending the features of parent and creating different electronic devices
4.Strategy pattern for deciding at runtime which command needs to be handled
5.State design pattern for maintaining the state of the devices whether on or off
6.Command design pattern for handling commands for switching on and off for different devices
7.Observer pattern for generating different billing related patterns.
8.Bridge or adapter pattern for deciding at run time which class needs to be instantiated for calling switching on and off.

Few patterns that could be used were as follows
1.Proxy pattern for not exposing direct interface for the users.
2.Prototype pattern for creating cloned instances of different POJO's like floor or hotel where we dont need underlying layer to be cloned.

OOPS principle followed
1.Single responsibility principle
2.Liskov substituion principle
3.Associative and composite and inheritence
4.Depenedency injection
5.open closed principle followed a bit(but can be followed in detail if project is exposed as a jar by maven plugin)

Packages details;-
App.java is the main class from where the execution starts.
1.com.sahaj.soft.hotel_automation.utils:- Contains common functions and can be used for others
2. com.sahaj.soft.hotel_automation:- Contains controllers for handling the first input which can be changed as exposed as rest api later on.
3. com.sahaj.soft.hotel_automation.commands:- Contains all command related interfaces to extend functionality for different devices.
4. com.sahaj.soft.hotel_automation.events:- Creating different kind of events
5. com.sahaj.soft.hotel_automation.eventsReceiver:- Creating event receivers.
6.com.sahaj.soft.hotel_automation.model:- Creating different model classes for pojo handling for hotel,floor,main and subcorridor and electronics device.
7.com.sahaj.soft.hotel_automation.states:- Managing different states of devices
8.com.sahaj.soft.hotel_automation.scheduler :- calling scheduler service can be extended for different communication on the basis of switching off and automating the process on no movement.(Didnt had much time to add but can be added).


Please do raise a query on any of these and will create an extended version of this on the basis of spring modules.
Thanks

