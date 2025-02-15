package assignment3;

import java.util.Comparator;


public class Job<K,V> implements Entry<Integer, String> {
    private K key;
    private V value;
	private String jobName;
	private int jobLength;
	private int currentJobLength;
	private int jobPriority;
	private int finalPriority;
	private int entryTime;
	private int waitTime;
	private int endTime;
	private boolean pure;  //to check whether the job has been processed yet
	
	public Job(int jobNumber, int jobLength, int jobPriority) {
		this.jobName = "JOB_"+jobNumber;
		this.jobLength = jobLength;
		this.currentJobLength = jobLength;
		this.jobPriority = jobPriority;
		this.finalPriority = jobPriority;
		this.entryTime = 0;
		this.waitTime = 0;
		this.endTime = 0;
		pure=true;
	}
	

	public Job(Job j) {
		this.jobName = j.jobName;
		this.jobLength = j.jobLength;
		this.currentJobLength = j.currentJobLength;
		this.jobPriority = j.jobPriority;
		this.finalPriority = j.finalPriority;
		this.entryTime = j.entryTime;
		this.waitTime = j.waitTime;
		this.endTime = j.endTime;
		pure=true;
	}
	public Job Clone() {
		return new Job(this);
	}

	public String toString() {
		return jobName+" Job Length: "+ jobLength+ " Entry Time: "+ entryTime +" Remaining Cycles: "+ currentJobLength+" Initial Priority: "+ jobPriority+" CurrentPriority "+ finalPriority; 
	}
	
	
	public boolean process() {
		this.currentJobLength--;
		this.pure=false;
		if (currentJobLength>0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void terminateJob(int endTime) {
		this.endTime = endTime;
		this.waitTime = endTime-entryTime-jobLength;//-jobLength because when it is executed,it wont wait		
	}
	
	public boolean isPure() {
		return pure;
	}
	
	
	public String getJobName() {
		return jobName;
	}

	public int getCurrentJobLength() {
		return currentJobLength;
	}

	public void setCurrentJobLength(int currentJobLength) {
		this.currentJobLength = currentJobLength;
	}

	public int getFinalPriority() {
		return finalPriority;
	}

	public void setFinalPriority(int finalPriority) {
		this.finalPriority = finalPriority;
	}

	public int getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(int entryTime) {
		this.entryTime = entryTime;
	}

	public long getWaitTime() {
		return waitTime;
	}
	
    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}


	@Override
	  public Integer getKey() {
        return finalPriority;
    }

    @Override
    public String getValue() {
        return jobName;
    }



	
}