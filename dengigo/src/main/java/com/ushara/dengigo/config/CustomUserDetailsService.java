package com.ushara.dengigo.config;


public class CustomUserDetailsService UserDetailsService{
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userDao.getByLogin(s);
        if(user==null) {
            throw new UsernameNotFoundException("user not found");
        }
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
        return userDetails;
    }

    List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        // ADMIN has USER authority
        if(user.getRole().getName().equals("ADMIN")){
            authorities.add(new SimpleGrantedAuthority("USER"));
        }
        return authorities;
    }
}
