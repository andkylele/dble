package io.mycat.backend.mysql.nio.handler.query;

import java.util.Set;

import io.mycat.backend.mysql.nio.handler.ResponseHandler;

public interface DMLResponseHandler extends ResponseHandler {
	public enum HandlerType {
		DIRECT, TEMPTABLE, BASESEL, REFRESHFP, MERGE, JOIN, WHERE, GROUPBY, HAVING, ORDERBY, LIMIT, UNION, DISTINCT, SENDMAKER, FINAL
	}

	HandlerType type();

	DMLResponseHandler getNextHandler();

	void setNextHandler(DMLResponseHandler next);

	Set<DMLResponseHandler> getMerges();

	boolean isAllPushDown();

	void setAllPushDown(boolean allPushDown);

	void setLeft(boolean isLeft);

	void terminate();

}