package com.ushara.dengigo.controller;

@Controller
public class RequestController {
    @Autowired
    RequestDao requestDao;
    @Autowired
    RequestTypeDao requestTypeDao;

    @Autowired
    TempDao tempDao;

    @RequestMapping(value = "/listRequest", method = RequestMethod.GET)
    public String listRequestPage(Model listRequest){
        List<Request> listRequests =  requestDao.getAll();
        listRequest.addAttribute("listRequests", listRequests);
        return "listRequest";
    }

    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.GET)
    public String addRequestCreatorPage(Model addRequestCreator){
        List<RequestType> requestTypes =  requestTypeDao.getAll();
        List listTitleRequestTypes = new ArrayList();
        for (RequestType requestType : requestTypes
                ) {listTitleRequestTypes.add(requestType.getTitle());
        }
        addRequestCreator.addAttribute("listTitleRequestTypes", listTitleRequestTypes);
        return "addRequestCreator";
    }

    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.POST)
    public ModelAndView addRequestCreator(@RequestParam("name") String name,
                                          @RequestParam("description") String description,
                                          @RequestParam("typerequest") String typerequest) {
        ModelAndView model = new ModelAndView();
        Request request = new Request();
        request.setTitle(name);
        request.setDescription(description);
        request.setStatus(New);
        request.setVersion(1);
        request.setCreatedDate(new Date());
        RequestType requestType =  requestTypeDao.getByTitle(typerequest);
        request.setRequestType(requestType);
        requestDao.save(request);
        model.setViewName("addRequestCreator");
        return model;
    }

    // добавление запроса на редкатирование
    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.GET)
    public String addRequestPerformerPage(Model addRequestPerformer, @RequestParam("idRequest") String idRequest){
        Request request =  requestDao.getByRequestId(Integer.parseInt(idRequest));
        addRequestPerformer.addAttribute("request", request);

        List<RequestType> requestTypes =  requestTypeDao.getAll();
        List listTitleRequestTypes = new ArrayList();
        for (RequestType requestType : requestTypes
                ) {listTitleRequestTypes.add(requestType.getTitle());
        }
        addRequestPerformer.addAttribute("listTitleRequestTypes", listTitleRequestTypes);

        return "addRequestPerformer";
    }

    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.POST)
    public ModelAndView addRequestPerformer(@RequestParam("idRequest") String idRequest,
                                            @RequestParam("name") String name,
                                            @RequestParam("description") String description,
                                            @RequestParam("dateCreator") String dateCreator,
                                            @RequestParam("typerequest") String typerequest) {
        ModelAndView model = new ModelAndView();
        Request request = requestDao.getByRequestId(Integer.parseInt(idRequest));
        request.setTitle(name);
        request.setDescription(description);
        request.setStatus(Declined);
        request.setUpdatedDate(new Date());
        RequestType requestType =  requestTypeDao.getByTitle(typerequest);
        request.setRequestType(requestType);
        //  request.setVersion(1);
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            Date date= format.parse(dateCreator);
            request.setCreatedDate(date);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        requestDao.update(request);
        model.setViewName("addRequestPerformer");
        return model;
    }
}
