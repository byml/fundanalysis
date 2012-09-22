package net.byml.util;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class DataDefinition implements DataType {
	private short position;
	private String key;
	private int dataType;

	public DataDefinition(String key, int dataType) {
		super();
		this.position = -1;
		this.key = key;
		this.dataType = dataType;
	}

	public DataDefinition(short position, String key, int dataType) {
		super();
		this.position = position;
		this.key = key;
		this.dataType = dataType;
	}

	public short getPosition() {
		return position;
	}

	public void setPosition(short position) {
		this.position = position;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
