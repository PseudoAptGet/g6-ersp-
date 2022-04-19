# README DOC

# A BRIEF NOTE ON BEST PRACTICES

In order to have cross-platform transfer of data, and to enable future cohorts to use their favorite languages (even FORTRAN) to build on the existing libraries and output files, we recommend storing outputs on csv files, and then using it for inputs for future programs/scripts. That way, csv files are used in the same manner as JSON in server interactions for web systems. 

We use this approach because Java is best optimized for reading in large amounts of data, and conducting conputationally expensive tasks, but Python and R has better library support for standard functions such as t-tests and k-means clustering. Having separate outputs at each step ensures that proper best practices can be taken at each step without worrying about data interaction between different languages, and creating a script that compiles everything.

# SETUP 

We simply provide the files necessary to do the analysis in an ordered manner. We will describe what the scripts do in the section below, as well as how to optimally chain them. You, the user, have the job of configuring multiple environments so that the program runs as expected, and the methods are chained in the appropriate method (manually if need be). Likewise, you need to manipulate the filepath of the data csv's so that the scripts have access to their input. 

# SCRIPT DESCRIPTION + USAGE
NOTE: please get all input files related to student and teacher data from the MathSpring team. Our output files are dummy files with old data that demonstrates how the output should look like. 

## Our Parsed Data
- studentAverages.csv: has a list of all the students, as well as their key metrics (average mistakes, average time taken per problme, average attempts before a problem is solved, average number of hints before problem is solved, average problem solve rate, as well as what problems they saw. 
- teacher-to-student.csv: has a list of teacher id's, as well as the student id's they map to. 
- teacher_action_freq_data.txt: shows the clusters of teacher actions, followed by the teacher frequency of those actions as a (int teacherId, int frequency) pair. 
- TODO: For each cluster of teachers, pool their students into one group. 
- TODO: For each pool of student, generate their performance metric average. 
- TODO: Do 2-sample t-tests to calculate statistical significance of each pool of students. 

# HOW TO CHAIN THE SCRIPTS
- First, check your teacher frequency log csv. Run teacher analysis to it to produce the teacher_action_freq_data.txt script. 
- Cluster the teachers on (https://people.revoledu.com/kardi/tutorial/kMean/Online-K-Means-Clustering.html) to see the clusters. 
- Generate studentAverages.csv by going through the student data with (insert here) to get student averages.
- Generate teacher_to_student.csv by looking through the student activity log to parse the teacher averages. 
- TODO: For each cluster of teachers in teacher_action_freq_data.txt, calculate their average student statistics by using studentAverages.csv
- TODO: For each cluster's average, compare it to the global average (using 2 sample t tests) and assess whether there is a statistically significant difference. 

