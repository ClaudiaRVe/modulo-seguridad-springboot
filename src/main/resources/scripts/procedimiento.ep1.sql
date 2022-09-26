create procedure listarAllUsers()

begin

	select * from users;

end

call listarAllUsers();
end