/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask2014.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;
import pl.mariuszczarny.slask2014.model.Training;
import pl.mariuszczarny.slask2014.service.ITrainingService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "trainingController")
@SessionScoped
public class TrainingController implements Serializable {

    @ManagedProperty(value = "#{trainingService}")
    ITrainingService trainingService;
    @ManagedProperty(value = "#{messageController}")
    private MessageController messageController;   
    
    private final static String SUCCESS = "zapisuje";
    private final static String ERROR = "zapisuje";

    List<Training> trainingList;
    List<String> trainingChoises;
    List<String> train;
    String trainingName;
    Training selectedTraining;
    private Long id;
    private List<TrainingGrid> grid;

    public TrainingController() {
        id=0L;
        selectedTraining=new Training();
        trainingChoises = new ArrayList<>();
        grid = new ArrayList<>();
        trainingName="";
    }
    
    @PostConstruct
    public void init(){
        trainingList = new ArrayList<Training>();
        trainingList.addAll(getTrainingService().findAllByCriteria());
        for(Training t:trainingList){
            if(t.getTrainingName().equals("General")){
                selectedTraining=t;
            }
        }
        onRowSelect();
    }
    
    public String prepareEdit() {
        return "EditTournament";
    }
    
    public String prepareAdd()
    {
        return "AddTournament";
    }
    
    public void destroy() {
        getTrainingService().delete(selectedTraining);
    }
    
    public String update()
    {
        System.out.println(selectedTraining);
        try {
            selectedTraining.setId(id);
            if(!getTrainingName().equals(selectedTraining.getTrainingName()))
            selectedTraining.setTrainingName(getTrainingName());
            
            resetTraining(selectedTraining);
            for(String choise:trainingChoises)
            {
                selectedTraining.setByString(choise);
            }
        getTrainingService().update(selectedTraining);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }  
        return selectedTraining.toString();
    }
    
    public String save()
    {
        System.out.println("Start saving");
        Training training = new Training();
        resetTraining(training);
        training.setId((long)getTrainingService().findAllByCriteria().size()+1);
        training.setTrainingName(getTrainingName());
        for(String choise: trainingChoises)
            {
                training.setByString(choise);
            }
         try {                
            getTrainingService().add(training);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
        return ERROR + " - " + training.toString();
    }
    
    public void resetTraining(Training train)
    {
        train.setPace(Boolean.FALSE);
        train.setStrength(Boolean.FALSE);
        train.setStamina(Boolean.FALSE);
        train.setSetPieces(Boolean.FALSE);
        train.setTechnique(Boolean.FALSE);
        train.setFinishing(Boolean.FALSE);
        train.setPassing(Boolean.FALSE);
        train.setMarking(Boolean.FALSE);
        train.setTackling(Boolean.FALSE);
        train.setHeading(Boolean.FALSE);
        train.setReflex(Boolean.FALSE);
        train.setHandling(Boolean.FALSE);
    }
    
    public void onRowSelect(){
        grid.clear();
        grid.add(new TrainingGrid("Wykończenie",selectedTraining.getFinishing()));
        grid.add(new TrainingGrid("Drybling",selectedTraining.getHandling()));
        grid.add(new TrainingGrid("Gra głową",selectedTraining.getHeading()));
        grid.add(new TrainingGrid("Krycie",selectedTraining.getMarking()));
        grid.add(new TrainingGrid("Tempo",selectedTraining.getPace()));
        grid.add(new TrainingGrid("Podania",selectedTraining.getPassing()));
        grid.add(new TrainingGrid("Reflex",selectedTraining.getReflex()));
        grid.add(new TrainingGrid("Stałe fragmenty gry",selectedTraining.getSetPieces()));
        grid.add(new TrainingGrid("Wytrzymałość",selectedTraining.getStamina()));
        grid.add(new TrainingGrid("Siła",selectedTraining.getStrength()));
        grid.add(new TrainingGrid("Odbiór piłki",selectedTraining.getTackling()));
        grid.add(new TrainingGrid("Technika",selectedTraining.getTechnique()));
    }
    
    public void onRowUnselect(){
        grid.clear();
    }

    public ITrainingService getTrainingService() {
        return trainingService;
    }

    public void setTrainingService(ITrainingService trainingService) {
        this.trainingService = trainingService;
    }

    public List<TrainingGrid> getGrid() {
        return grid;
    }

    public void setGrid(List<TrainingGrid> grid) {
        this.grid = grid;
    }
    
    public List<Training> getTrainingList() {
        getMessageController().getMessageList().add("pokaż listę treningów");
        return trainingList;
    }

    public void setTrainingList(List<Training> trainingList) {
        this.trainingList = trainingList;
    }
    
    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
    
    public MessageController getMessageController()
    {
        return messageController;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public List<String> getTrainingChoises() {
        return trainingChoises;
    }

    public void setTrainingChoises(List<String> trainingChoises) {
        this.trainingChoises = trainingChoises;
    }

    public Training getSelectedTraining() {
        return selectedTraining;
    }

    public void setSelectedTraining(Training selectedTraining) {
        this.selectedTraining = selectedTraining;
    }

    public List<String> getTrain() {
        train = new ArrayList<>();
        train.add("Pace");
        train.add("Strength");
        train.add("Stamina");
        train.add("SetPieces");
        train.add("Technique");
        train.add("Finishing");
        train.add("Passing");
        train.add("Marking");
        train.add("Tackling");
        train.add("Heading");
        train.add("Reflex");
        train.add("Handling");
        return train;
    }

    public void setTrain(List<String> train) {
        this.train = train;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public class TrainingGrid{
        private String attributesName;
        private Boolean value;
        
        public TrainingGrid(String attributesName, Boolean value){
            this.attributesName = attributesName;
            this.value = value;
        }

        public String getAttributesName() {
            return attributesName;
        }

        public void setAttributesName(String attributesName) {
            this.attributesName = attributesName;
        }

        public Boolean getValue() {
            return value;
        }

        public void setValue(Boolean value) {
            this.value = value;
        }
    }
    
}
