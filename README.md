# dye
Dye &amp; Durham -- assessment.

This application was written with the java 8 compiler in mind. You wlll need to setup
your given enivronment in the provided batch environment file.

This is a multi-tierd application, with the core and meat of the application
to be found in the list_sorted() function. This is a relatively straight-forward
implementation, - although given it's nature it is still fundamentally complex.

The following is a brief flow-chart to define the procedural aspects of the software.

(1) Input through standard arguments at startup, to provide the file location for sorting.
(2) If the file was not provided at run-time, a prompt is issued.
(3) Call the read_file_list() function to take in the textual/input values.
(4) Call the list_sorted() function, which parses the input, sorts the last names
and assigns the full names in a trailing context.
(5) Call the write_file_list() function to output all given values to a file.
