package com.ushara.dengigo.controller;

@Controller
public class AppController {
    private static final Logger log = Logger.getLogger("CreateTable");

    @Autowired
    CreateTable createTable;
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @RequestMapping("/")
    public String hello(Model model){
//        model.addAttribute("hello", messageService.getInfo());
        // get security context from thread local
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return "index";
        }
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return "index";
        }
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            log.info("\r\n==================== ROLE = " + auth.getAuthority());
        }
        return "index";
    }

    @RequestMapping("/gnome")
    public String hello2(Model model){
        return "gnome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout){
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout){
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register( User usr  ){
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Post registration form"+ usr.getLogin());

        Role role =  roleDao.getByName("ROLE_USER");
        usr.setRole(role);
        usr.setPassword(new BCryptPasswordEncoder().encode(usr.getPassword()));
        usr.setCreatedBy(usr.getLogin());
        usr.setUpdatedBy(usr.getLogin());
        userDao.save(usr);
        model.setViewName("register");
        return model;
    }

    @RequestMapping("/first")
    public String firstPage(Model model){
        model.addAttribute("user", new User().getLogin());
        return "first";
    }

    @RequestMapping("/second")
    public String secondPage(Model model, @ModelAttribute User modelUser){
        model.addAttribute("user", modelUser);
        return "second";
    }

    @RequestMapping("/createtable")
    public String createTable(Model model){
        model.addAttribute("createTable", createTable.createTable());
        return "createtable";
    }

    @RequestMapping(value = "password/{password}", method = RequestMethod.GET)
    public String password(@PathVariable("password")String password, Model model){
        model.addAttribute("crypt", new BCryptPasswordEncoder().encode(password));
        return "password";
    }
}
