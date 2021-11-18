package com.test.trading.model;

import java.util.Date;

public class Trade {

	
	private String tradeID;
	private long version;
	private String counterPartyID;
	private String bookID;
	private Date maturityDate;
	private Date creationDate;
	private boolean expired;
	public String getTradeID() {
		return tradeID;
	}
	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getCounterPartyID() {
		return counterPartyID;
	}
	public void setCounterPartyID(String counterPartyID) {
		this.counterPartyID = counterPartyID;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		result = prime * result + ((counterPartyID == null) ? 0 : counterPartyID.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + (expired ? 1231 : 1237);
		result = prime * result + ((maturityDate == null) ? 0 : maturityDate.hashCode());
		result = prime * result + ((tradeID == null) ? 0 : tradeID.hashCode());
		result = prime * result + (int) (version ^ (version >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		if (counterPartyID == null) {
			if (other.counterPartyID != null)
				return false;
		} else if (!counterPartyID.equals(other.counterPartyID))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (expired != other.expired)
			return false;
		if (maturityDate == null) {
			if (other.maturityDate != null)
				return false;
		} else if (!maturityDate.equals(other.maturityDate))
			return false;
		if (tradeID == null) {
			if (other.tradeID != null)
				return false;
		} else if (!tradeID.equals(other.tradeID))
			return false;
		if (version != other.version)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Trade [tradeID=" + tradeID + ", version=" + version + ", counterPartyID=" + counterPartyID + ", bookID="
				+ bookID + ", maturityDate=" + maturityDate + ", creationDate=" + creationDate + ", expired=" + expired
				+ "]";
	}
	
	
}
