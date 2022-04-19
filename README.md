# README DOC

# A BRIEF NOTE ON BEST PRACTICES

In order to have cross-platform transfer of data, and to enable future cohorts to use their favorite languages (even FORTRAN) to build on the existing libraries and output files, we recommend storing outputs on csv files, and then using it for inputs for future programs/scripts. That way, csv files are used in the same manner as JSON in server interactions for web systems. 

We use this approach because Java is best optimized for reading in large amounts of data, and conducting conputationally expensive tasks, but Python and R has better library support for standard functions such as t-tests and k-means clustering. Having separate outputs at each step ensures that proper best practices can be taken at each step without worrying about data interaction between different languages, and creating a script that compiles everything.


