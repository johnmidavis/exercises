# this is a leg up to a comrade studying ruby
# it probably used bad form in many ways

#create an instance hashtable for adding sums up
@power = Hash.new

# main method - magic at the bottom makes it run
def process
    # here is a starting directory
    main_dir = '/home/john/code/ruby/files'
    # let's go to the directory we want
    Dir.chdir(main_dir)
    #print the present working directory (pwd)
    puts Dir.pwd
    # glob is stolen from Perl - list all the 
    # matches for the wildcard pattern "*"
    listing = Dir.glob("*")
    # put out the list
    puts listing.inspect


    #let's process the subdirectories and discard other files
    listing.each do |f|
       if File.directory? f
         processDirectory f
       else
         puts "ignoring file: " + f
       end
    end

    puts @power.inspect
end

def processDirectory(dir_name)
  puts "processing directory" + dir_name
  Dir.chdir(dir_name)
  cvs_files = Dir.glob('*.csv')
  puts "files ..  " + cvs_files.inspect
  cvs_files.each do |file|
     File.readlines(file).each do |line|
        entries = line.split("\t")
        if entries[0].eql? "brick"
           puts "ignoring header line"
        else
           brick = entries[0].to_s
           watts = entries[1].to_i
           if @power.include? "brick" + brick
              @power[ "brick" + brick ] += watts
           else
              @power[ "brick" + brick ] = watts
           end # end of the line is not a header line check
        end # end of the each line loop 
     end # end of the each line loop
  end # end of the each file loop

  #get back up to the parent directory
  Dir.chdir("..")
end

if __FILE__ == $0
   process()
end
